
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="cheminajouter" >
    <spring:url value="/hotel/ajouter"/>
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
        <form:form modelAttribute="hotels" action="${cheminajouter}">
            <label>Nom de l'hotel</label>
            <form:input path="nom"/>
            <label>Rue</label>
            <form:input path="adresse.rue"/>
            <label>Numero</label>
            <form:input path="adresse.numero"/>
            <label>Localite</label>
            <form:input path="adresse.localite"/>
            <input type="submit" value="Ajouter"/>

        </form:form>

    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
