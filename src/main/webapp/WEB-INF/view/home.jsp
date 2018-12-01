<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%--
  Created by IntelliJ IDEA.
  User: ladam
  Date: 11/27/2018
  Time: 6:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title of the page</title>
</head>
<body>


<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <c:if test="${param.logout != null}">
        <i>You have been logged out!</i>
    </c:if>
    <input type="submit" value="Logout"/>
</form:form>






    <h2>Home Page</h2>
    <hr>
    <p>Welcome to the home page!</p>
</body>
</html>
