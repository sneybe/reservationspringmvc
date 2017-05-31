<%-- 
    Document   : lister
    Created on : 31 mai 2017, 13:34:29
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <a href='<spring:url value="/chambre/ajouter"/>'>AJouter Chambre</a>
    <contenu>
        <h1>Liste des chambres </h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOM</th>
                    <th>PRIX</th>
                    <th>SUPPRIMER</th>
                    <th>MODIFIER</th>
                </tr>

            </thead>
            <tbody>
                <c:forEach items="${chambres}" var="ch">

                    <tr>
                        <td>${ch.id}</td>   
                        <td>${ch.nom}</td>
                        <td>${ch.prix}</td> 
                        <td><a href='<spring:url value="/chambre/supprimer/${ch.id}"/>'>Supprimer</a></td>
                            <td><a href='<spring:url value="/chambre/modifier/${ch.id}"/>'>Modifier</a></td>
                            </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </contenu>
                <c:import url="../_FOOTER.jsp"></c:import>  
            </body>
        </html>
