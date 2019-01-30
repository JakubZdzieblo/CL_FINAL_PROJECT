<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css"
          crossorigin="anonymous">
    <title>Details</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><h3>GAMING BACKLOG</h3></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03"
            aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="backlog">Your backlog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="otherBacklogs">Others backlogs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="filter">Games filter</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search" method="post">
            <input class="form-control mr-sm-2" type="text" name="query" placeholder="Game name">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Find a game</button>
        </form>
    </div>
</nav>
<br><br>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-xl-6">
            <div class="card">
                <h3 class="card-header">${game.name}</h3>
                <div class="card-body">
                    <h6 class="card-subtitle text-muted">${game.deck}</h6>
                </div>
                <p><img class="mx-auto d-block" style="object-fit: contain; max-height: 400px" src="${game.imageUrl}">
                </p>
            </div>
        </div>
        <div class="col-xl-3">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header"><h4>Platforms</h4></div>
                <div class="card-body">
                    <ul>
                        <c:forEach items="${game.platforms}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Themes</div>
                <div class="card-body">
                    <ul>
                        <c:forEach items="${game.themes}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-xl-3">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Genres</div>
                <div class="card-body">
                    <ul>
                        <c:forEach items="${game.genres}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Concepts</div>
                <div class="card-body">
                    <ul>
                        <c:forEach items="${game.concepts}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>
</div>
</body>
</html>
