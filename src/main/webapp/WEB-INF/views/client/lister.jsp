
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <a href='<spring:url value="/client/ajouter"/>'>Ajouter Client</a>
        <contenu>
            <table border='1'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOM</th>
                        <th>PRENOM</th>
                        <th>RUE</th>
                        <th>NUMERO</th>
                        <th>LOCALITE</th>
                        <th>ZIP</th>
                        <th>PAYS</th>
                        <th>ACTIONS</th>
                        <th>ACTIONS</th>
                    </tr>

                </thead>
                <tbody>
                <c:forEach items="${monclient}" var="cl">
                    <tr>
                        <td>   ${cl.id}</td>
                        <td>  ${cl.nom}</td>
                        <td> ${cl.prenom}</td>
                        <td> ${cl.adresse.rue}</td>
                        <td> ${cl.adresse.numero}</td>
                        <td>${cl.adresse.localite}</td>
                        <td> ${cl.adresse.zip}</td>
                        <td> ${cl.adresse.pays}</td>

                        <td><a href='<spring:url value="/client/supprimer/${cl.id}"/>'>Supprimer</a></td>
                        <td><a href='<spring:url value="/client/modifier/${cl.id}"/>'>Modifier</a></td>
                    </tr>
                </c:forEach>
            </tbody>            
        </table>   

    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
