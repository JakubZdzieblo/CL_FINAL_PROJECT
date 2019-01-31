<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=""><h3>GAMING BACKLOG</h3></a>
</nav>
<div class="container">
    <BR><BR>
    <h3 class="text-center">LOGIN PLEASE</h3>
    <BR><BR>
    <form:form method="post" action="/login/check" modelAttribute="user">
        <form:input path="login" placeholder="Login"/>
        <form:errors path="login" cssStyle="color: darkred"/><BR><BR>
        <form:password path="password" placeholder="Password"/>
        <form:errors path="password" cssStyle="color: darkred"/><BR><BR>
        <form:button>LOGIN</form:button>
    </form:form>
</div>
<h3><a href="/login/register">REGISTER NEW USER</a></h3>
<br><br>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>
