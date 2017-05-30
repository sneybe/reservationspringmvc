
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="chambreajouter" >
   <spring url="/chambre/ajouter"/>
    
</c:set>
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
            <form:form modelAttribute="chambres" action="${chambreajouter}">
            <label>Nom de la chambre</label>
            <form:input path="nom"/>
            <label>Prix</label>
            <form:input path="prix"/>
            <form:select path="hotel.id" items="${hotel}" itemValue="id" itemLabel="nom"/>
            
            <input type="submit" value="Ajouter"/>




        </form:form>
    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
