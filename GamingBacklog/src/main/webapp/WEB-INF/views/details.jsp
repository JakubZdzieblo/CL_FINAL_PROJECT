<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css"
          crossorigin="anonymous">
    <title>Details</title>
    <style>
        card{overflow: hidden}
    </style>
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
                <h3 class="card-header">${game.name}
                    <a href="/addToBacklog?gbId=${game.gbId}">
                    <button class="btn btn-primary float-right">Add to backlog</button></a></h3>
                <div class="card-body">
                    <h5 class="card-subtitle">${game.deck}</h5>
                    <br>
                    <h6 class="card-subtitle text-muted">${game.original_release_date}</h6>
                </div>
                <p><img class="mx-auto d-block" style="object-fit: contain; max-height: 400px" src="${game.imageUrl}">
                </p>
                <div class="card-body">
                    <c:forEach items="${game.platforms}" var="el">
                        <span class="badge badge-primary">${el.name}</span>
                    </c:forEach>
                </div>
                <div class="card-body">
                    <c:forEach items="${game.genres}" var="el">
                        <span class="badge badge-secondary">${el.name}</span>
                    </c:forEach>
                </div>
                <div class="card-body">
                    <c:forEach items="${game.themes}" var="el">
                        <span class="badge badge-info">${el.name}</span>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-xl-3">
            <div class="card h-30 border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Publishers</div>
                <div class="card-body text-truncate">
                    <ul>
                        <c:forEach items="${game.publishers}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="card h-50 border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Objects</div>
                <div class="card-body text-truncate">
                    <ul>
                        <c:forEach items="${game.gameObjects}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-xl-3">
            <div class="card h-30 border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Locations</div>
                <div class="card-body text-truncate">
                    <ul>
                        <c:forEach items="${game.locations}" var="el">
                            <li>${el.name}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="card h-50 border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Concepts</div>
                <div class="card-body text-truncate">
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
    <div class="row justify-content-center">
        <div class="jumbotron col-xl-12">
            ${game.description}
        </div>

    </div>
    <br>
    <p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>
</div>
</body>
</html>
