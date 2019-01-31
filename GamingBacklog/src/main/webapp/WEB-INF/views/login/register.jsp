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
<div class="container">
    <h3>New user</h3>
    <form:form method="post" action="/login/save" modelAttribute="user">
        <form:input path="name" placeholder="Full Name"/>
        <form:errors path="name" cssStyle="color: darkred"/><BR><BR>
        <form:input path="email" placeholder="Email"/>
        <form:errors path="email" cssStyle="color: darkred"/><BR><BR>
        <form:input path="login" placeholder="Login"/>
        <form:errors path="login" cssStyle="color: darkred"/><BR><BR>
        <form:password path="password" placeholder="Password"/>
        <form:errors path="password" cssStyle="color: darkred"/><BR><BR>
        <input type="password" name="repeatedPassword" placeholder="Repeat password"/>
        <span Style="color: darkred">${error}</span><BR><BR>
        <form:button>Submit</form:button>
    </form:form>
</div>
</body>
</html>
