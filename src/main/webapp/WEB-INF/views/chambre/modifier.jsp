<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>        
        <c:set var="cheminmodif">
            <spring:url value="/chambre/modifier"/>

        </c:set> 

        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenu>
            <h1>Modifier chambre</h1>
        <form:form modelAttribute="chamb" action="${cheminmodif}">
            <form:hidden path="id"/>
            <label>Nom Chambre</label>
            <form:input path="nom"/>
            <label>prix</label>
            <form:input path="prix"/>

            <input type="submit"/>

        </form:form>
    </contenu>
    <c:import url="../_FOOTER.jsp"></c:import>  
</body>
</html>
