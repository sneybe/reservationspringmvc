
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
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


                    </tr>
                </c:forEach>
            </tbody>            
        </table>   

    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
