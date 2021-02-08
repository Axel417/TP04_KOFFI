<%-- 
    Document   : newAccount
    Created on : 5 févr. 2021, 21:39:39
    Author     : Axel Koffi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <body>

        <nav class="navbar navbar-dark bg-dark">
            <!-- Navbar content -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link" href="index.html">Acceuil <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="newAccount.jsp">Ajouter un compte Bancaire</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServletComptes?action=ListerCompte">Liste des comptes Bancaires</a>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">

            <div class="row justify-content-md-center" style="margin-top: 20px">
                
                <div class="container">
                    
                    <div class="alert alert-primary" role="alert">
                        <center>Création d'un compte banquaire</center>  
                    </div>
                    
                    <form action="ServletComptes" method="post">
                        <div class="form-group">
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" id="nom" required  name="nom">

                        </div>
                        <div class="form-group">
                            <label for="prenom">Prenom</label>
                            <input type="text" class="form-control" id="prenom" required  name="prenom">

                        </div>
                        <div class="form-group">
                            <label for="numCompte">Numero de compte</label>
                            <input type="text" class="form-control" id="numCompte" required  name="numCompte">

                        </div>
                        <div class="form-group">
                            <label for="balance">Solde</label>
                            <input type="text" class="form-control" id="balance"  required name="balance">

                        </div>
                        <input type="hidden" name="action" value="creerNouveauCompte"/>
                        <button type="submit" class="btn btn-success">Valider</button>

                    </form>



                </div>
            </div>
        </div>


    </body>
</html>
