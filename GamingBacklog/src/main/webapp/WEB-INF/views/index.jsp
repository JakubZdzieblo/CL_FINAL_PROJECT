<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Index</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><h3>GAMING BACKLOG</h3></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
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
<div class="container">
    <BR><BR>
    <h3 class="text-center">Random game of the moment:</h3>
    <BR><BR>
    <div class="col-lg-12">
        <div class="bs-component">
                <div class="card mb-12">
                    <h3 class="card-header">${game.name}
                        <a href="/addToBacklog?gbId=${game.gbId}">
                            <button class="btn btn-primary float-right">Add to backlog</button></a></h3>
                    <div class="card-body">
                        <h5 class="card-title">${game.deck}</h5>
                    </div>
                    <div class="card-body">
                        <img class="mx-auto d-block" style="object-fit: contain; max-height: 400px" src="${game.imageUrl}">
                    </div>
                    <div class="card-body">
                    <p><b>Platforms:</b>
                        <c:forEach items="${game.platforms}" var="plat">
                            <span class="badge badge-primary">${plat.name}</span>
                        </c:forEach>
                    </p>
                    </div>
                    <div class="card-body">
                        <a href="/details?gbId=${game.gbId}" class="card-link">Game details</a>
                    </div>
                </div>
        </div>
    </div>
</div>
<br><br>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>
