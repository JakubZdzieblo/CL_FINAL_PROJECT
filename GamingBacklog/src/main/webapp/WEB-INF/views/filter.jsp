<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Filter</title>
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
            <li class="nav-item">
                <a class="nav-link" href="backlog">Your backlog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="otherBacklogs">Others backlogs</a>
            </li>
            <li class="nav-item active">
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
    <div class="col-lg-12">
    <BR><BR>
    <h3 class="text-center">Select filtering conditions:</h3>
    <BR><BR>

    <form method="post" action="filter">
        <div class="row justify-content-center">
        <div class="form-group col-lg-6">
            <select class="custom-select" name="platform" required="required">
                <option selected="" disabled="disabled">Select platform</option>
                <c:forEach items="${platforms}" var="platform">
                <option value="${platform.gbId}">${platform.abbreviation} - ${platform.name}</option>
                </c:forEach>
            </select>
        </div></div>
        <div class="row justify-content-center">
        <div class="form-group">
            <label class="col-form-label" for="dateFrom">Release date between:</label>
            <input type="date" required="required" class="form-control col-lg-12" placeholder="Default input" id="dateFrom" name="dateFrom">
        </div>
            <div class="form-group">
            <label class="col-form-label" for="dateTo">and:</label>
            <input type="date" required="required" class="form-control col-lg-12" placeholder="Default input" id="dateTo" name="dateTo">
        </div>
        </div>
        <div class="row justify-content-center">
            <button class="btn btn-primary my-2 my-sm-0" type="submit">SUBMIT</button></div>
    </form>
    </div>
</div>
<br><br>
<p class="text-secondary text-center">All data from <a href="http://www.giantbomb.com">GiantBomb</a>.</p>

</body>
</html>
