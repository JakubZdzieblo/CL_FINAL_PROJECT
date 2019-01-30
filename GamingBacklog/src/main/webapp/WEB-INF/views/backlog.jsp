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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><h3>GAMING BACKLOG</h3></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="backlog">Your backlog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="otherBacklogs">Others backlogs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="filter">Games filter</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="search" method="post">
            <input class="form-control mr-sm-2" type="text" name="query" placeholder="Game name">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Find a game</button>
        </form>
    </div>
</nav>
<div class="container">
    <BR><BR>
    <h3 class="text-center">Backlog of ${user.name}</h3>
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
<br><br>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>

