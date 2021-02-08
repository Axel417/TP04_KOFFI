/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelet;

import CompteBancaireGestionnaire.GestionnaireCompteBancaire;
import CompteBancaireModele.CompteBancaire;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Axel Koffi
 */
public class ServletComptes extends HttpServlet {

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire1;

    @PersistenceContext
    private EntityManager em;

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";

       
             
        if (action != null) {
            switch (action) {
                
                case "ListerCompteBanquaire":
                    Collection<CompteBancaire> liste = gestionnaireCompteBancaire1.getAllCompte();
                    request.setAttribute("listeDesComptesBanquaire", liste);
                    forwardTo = "listAccount.jsp?action=ListerCompte";
                    message = "Liste des comptes bancaires";
                    break;
                case "creerNouveauCompte":
                    String prenom = request.getParameter("prenom");
                    String nom = request.getParameter("nom");
                    String numCompte = request.getParameter("numCompte");
                    double balance = Double.parseDouble(request.getParameter("balance"));
                    gestionnaireCompteBancaire1.creeUtilisateur(nom, prenom, numCompte, balance);
                    message = "Compte crée avec succès";
                    forwardTo = "newAccount.jsp?action=todo";
                    break;
                default:
                    forwardTo = "newAccount.jsp?action=todo";
                    message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
                    break;
            }
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
