<%-- 
    Document   : listAccount
    Created on : 5 févr. 2021, 21:40:02
    Author     : Axel Koffi
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTE DES COMPTES</title>
    </head>
    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <body>

         <nav class="navbar navbar-dark bg-dark">
            <!-- Navbar content -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link" href="index.html">Acceuil <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="newAccount.jsp">Ajouter un compte Bancaire</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ServletComptes?action=ListerCompte">Liste des comptes Bancaires</a>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">
            

            <div class="row justify-content-md-center" style="margin-top: 20px">


                <div class="container">
                    <div class="alert alert-primary" role="alert">
                        <center>Liste des comptes Banquaire</center>  
                    </div>

                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Numero de compte</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Prénom(s)</th>
                                <th scope="col">Solde</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0"/>
                            <c:forEach var="cb" items="${requestScope['listeDesComptesB']}">
                                <tr>
                                    <td>${cb.accountNumber}</td>
                                    <td>${cb.firstname}</td>
                                    <td>${cb.lastname}</td>
                                    <td>${cb.balance}</td>
                                    <c:set var="total" value="${total+1}"/>
                                </tr>
                            </c:forEach>
                            <tr><td><b>TOTAL</b></td><td></td><td></td><td><b>${total}</b></td></tr>
                        </tbody>
                    </table>


                </div>
            </div>
        </div>

  

</body>
</html>
