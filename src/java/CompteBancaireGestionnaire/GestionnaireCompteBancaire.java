/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompteBancaireGestionnaire;

import CompteBancaireModele.CompteBancaire;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Axel Koffi
 */
@Stateless
public class GestionnaireCompteBancaire {


    @PersistenceContext
    private EntityManager em;

      public void creerCompteBancaireDeTest() {
        creeCompte("koffi","Axel","CB01",50000);
         creeCompte("Soro","Axel","CB02",50000);
      }
       
    public CompteBancaire creeCompte(String nom, String prenom, String numero, double balance) {
        CompteBancaire u = new CompteBancaire(nom, prenom, numero, balance);
        em.persist(u);
        return u;
    }
    
    public CompteBancaire creeUtilisateur(String firstName, String lastName, String accountNumber,double balance) {
        CompteBancaire u = new CompteBancaire(firstName, lastName, accountNumber, balance);
        em.persist(u);
        return u;
    }

    public Collection<CompteBancaire> getAllCompte() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select u from CompteBancaire u");
        return q.getResultList();
    }

}
