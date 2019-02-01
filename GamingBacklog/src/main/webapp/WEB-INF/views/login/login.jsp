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
    <br><br>
    <div class="row justify-content-md-center">
    <div class=col-lg-auto">
    <h4 class="text-center">LOGIN PLEASE</h4><br>
    <form:form method="post" action="/login/check" modelAttribute="user" class="text-center">
        <form:input path="login" placeholder="Login"/><br>
        <form:errors path="login" cssStyle="color: lightcoral"/><BR>
        <form:password path="password" placeholder="Password"/><br>
        <form:errors path="password" cssStyle="color: lightcoral"/><BR>
        <form:button>LOGIN</form:button>
    </form:form>
<br>
<h4><a href="/login/register" class="text-center">REGISTER NEW USER</a></h4>
    <br><br>
    </div></div></div>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>
