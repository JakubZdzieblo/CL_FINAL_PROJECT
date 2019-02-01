<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">

    <title>Register</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=""><h3>GAMING BACKLOG</h3></a>
</nav>
<div class="container">
    <br><br>
    <div class="row justify-content-md-center">
        <div class="col-lg-auto text-center">
    <h4>Fill in your details</h4><br>
    <form:form method="post" action="/login/save" modelAttribute="user">
        <form:input path="name" placeholder="Full Name"/><BR>
        <form:errors path="name" cssStyle="color: lightcoral"/><BR>
        <form:input path="email" placeholder="Email"/><BR>
        <form:errors path="email" cssStyle="color: lightcoral"/><BR>
        <form:input path="login" placeholder="Login"/><BR>
        <form:errors path="login" cssStyle="color: lightcoral"/><BR>
        <form:password path="password" placeholder="Password"/><BR>
        <form:errors path="password" cssStyle="color: lightcoral"/><BR>
        <input type="password" name="repeatedPassword" placeholder="Repeat password"/>
        <span Style="color: darkred">${error}</span><BR><BR>
        <form:button>Submit</form:button>
    </form:form>
            <br>
            <h4><a href="/login" class="text-center">BACK TO LOGIN</a></h4>
        </div></div>

</div>
<br><br>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>
