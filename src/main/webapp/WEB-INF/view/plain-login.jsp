<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: ladam
  Date: 11/28/2018
  Time: 6:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom LoginPage</title>
</head>
<body>

<h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${param.error != null}">
        <i>Sorry! You entered invalid username/password.</i>
    </c:if>
    <p>
        <label for="username">User name:</label>
        <input type="text" name="username" id="username">
    </p>
    <p>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password">
    </p>

    <input type="submit" value="Login">

</form:form>

</body>
</html>
