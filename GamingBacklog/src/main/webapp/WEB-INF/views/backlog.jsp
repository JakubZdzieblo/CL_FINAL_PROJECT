<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Backlog</title>
</head>
<body>
<%@ include file="header.jsp"%>

<div class="container">

    <BR><BR>
    <h3 class="text-center">Your backlog</h3>
    <BR><BR>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Icon</th>
            <th scope="col">Game title</th>
            <th scope="col">Short info</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.games}" var="game">
        <tr><td><img src="${game.iconUrl}"/> </td>
            <th scope="row">${game.name}</th>
            <td>${game.deck}</td>
            <td><a href="details?gbId=${game.gbId}">
                <button type="button" class="btn btn-secondary">Details</button></a>
            </td>
            <td><a href="removeFromBacklog?gbId=${game.gbId}">
                <button type="button" class="btn btn-warning">Remove</button></a>
            </td>
        </tr>
        </c:forEach>
        </tbody></table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

