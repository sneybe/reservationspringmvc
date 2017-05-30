
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste hotels</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <a href='<spring:url value="/hotel/ajouter"/>'>Ajouter</a>
        <contenu>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th> 
                        <th>NOM</th>
                        <th>RUE</th>
                        <th>LOCALITE</th>
                        <th>PAYS</th>
                        <th>ZIP</th>
                        <th>ACTIONS</th>
                        <th>ACTIONS</th>
                       
                    </tr>

                </thead>
            <c:forEach items="${listeHotels}" var="h">
                <tbody>
                    <tr>
                        <td>${h.id}</td>
                        <td>${h.nom}</td>
                        <td>${h.adresse.rue}</td>
                        <td>${h.adresse.localite}</td>
                        <td>${h.adresse.pays}</td>
                        <td>${h.adresse.zip}</td>

                        <td><a href='<spring:url value="/hotel/supprimer/${h.id}"/>'>Supprimer</a></td>
                        <td><a href='<spring:url value="/hotel/modifier/${h.id}"/>'>Modifier</a></td>
                      
                    </tr> 

                </tbody>
            </c:forEach>

        </table>
    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
