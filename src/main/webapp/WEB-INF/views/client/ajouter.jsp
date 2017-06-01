
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var ="chemin">
    <spring:url value="/client/ajouter"/>
   
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
        <form:form modelAttribute="client" action="${chemin}">
            <form:input path="nom"/>
            <form:input path="prenom"/>
            <form:input path="adresse.rue"/>
            <form:input path="adresse.numero"/>
            <form:input path="adresse.localite"/>
            <form:input path="adresse.zip"/>
            <form:input path="adresse.pays"/>
            <input type="submit"/>
         </form:form>   
        </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
