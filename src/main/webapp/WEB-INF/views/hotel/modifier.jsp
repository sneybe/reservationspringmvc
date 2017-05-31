<%-- 
    Document   : modifier
    Created on : 30 mai 2017, 14:00:24
    Author     : Administrateur
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cheminmodif">
    <spring:url  value="/hotel/modifier"/>
</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenu>
            <h1>Modifier hotel</h1>
        <form:form modelAttribute="hotel" action="${cheminmodif}">
            <form:hidden path="id"/>
            <label>Nom hotel:</label>
            <form:input path="nom"/>
            <form:input path="prix"/>
            <input type="submit"/>

        </form:form>
    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
