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
<%@ include file="header.jsp"%>
<br><br>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-xl-6">
            <div class="card">
                <h3 class="card-header">${game.name}
                    <a href="/addToBacklog?gbId=${game.gbId}">
                    <button class="btn btn-primary float-right">Add to backlog</button></a>
                    </h3>
                <div class="card-body">
                    <h5 class="card-subtitle">${game.deck}</h5>
                    <br>
                    <h6 class="card-subtitle text-muted">${game.original_release_date}</h6>
                </div>
                <p><img class="mx-auto d-block" style="object-fit: contain; max-height: 400px" src="${game.imageUrl}">
                </p>
                <c:if test="${not empty game.platforms}">
                <div class="card-body text-wrap"><b>Platforms: </b>
                    <c:forEach items="${game.platforms}" var="el">
                        <span class="badge badge-primary">${el.name}</span>
                    </c:forEach>
                </div>
                </c:if>
                <c:if test="${not empty game.similarGames}">
                <div class="card-body text-wrap"><b>Similar games: </b>
                    <c:forEach items="${game.similarGames}" var="el">
                        <a href="details?gbId=${el.gbId}">${el.name}; </a>
                    </c:forEach>
                </div>
                </c:if>
                <div class="card-body text-wrap">
                <p><a href="#comments"><button class="btn btn-secondary float-right">Jump to comments
                </button></a></p></div>
            </div>
        </div>
        <div class="col-xl-3">
            <c:if test="${not empty game.publishers}">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Publishers</div>
                <div class="card-body text-wrap">
                    <c:forEach items="${game.publishers}" var="el">
                            <span class="badge badge-primary">${el.name}</span>
                        </c:forEach>
                </div>
            </div>
            </c:if>
            <c:if test="${not empty game.genres}">
                <div class="card border-secondary mb-3" style="max-width: 20rem;">
                    <div class="card-header">Genres</div>
                    <div class="card-body text-wrap">
                        <c:forEach items="${game.genres}" var="el">
                            <span class="badge badge-warning">${el.name}</span>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty game.themes}">
                <div class="card border-secondary mb-3" style="max-width: 20rem;">
                    <div class="card-header">Themes</div>
                    <div class="card-body text-wrap">
                        <c:forEach items="${game.themes}" var="el">
                            <span class="badge badge-dark">${el.name}</span>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty game.gameObjects}">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Objects</div>
                <div class="card-body text-wrap">
                        <c:forEach begin="0" end="70" items="${game.gameObjects}" var="el">
                            <span class="badge badge-info">${el.name}</span>
                        </c:forEach>
                </div>
            </div>
            </c:if>
        </div>
        <div class="col-xl-3">
            <c:if test="${not empty game.locations}">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Locations</div>
                <div class="card-body text-wrap">
                        <c:forEach items="${game.locations}" var="el">
                            <span class="badge badge-success">${el.name}</span>
                        </c:forEach>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty game.concepts}">
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Concepts</div>
                <div class="card-body text-wrap">
                        <c:forEach begin="0" end="70"  items="${game.concepts}" var="el">
                            <span class="badge badge-light">${el.name}</span>
                        </c:forEach>
                </div>
            </div>
        </c:if>
        </div>
    </div>
    <br><br>
    <c:if test="${not empty game.description}">
    <div class="row justify-content-center">
        <div class="jumbotron col-xl-12 text-justify">
            ${game.description}
        </div>
    </div>
    </c:if>
    <div class="row justify-content-center" id="comments">
        <div class="col-xl-12">
            <div class="card border-secondary mb-12">
                <div class="card-header"><h5>Comments<a href="comments/addComment?gbId=${game.gbId}">
                    <button class="btn btn-primary float-right">Add Comment</button></a></h5></div>
                    <c:forEach items="${comments}" var="el">
                        <div class="card-body">
                            <p class="text-muted"><i>by <b>${el.user}</b> on ${el.created}</i></p>
                            ${el.text}
                          </div>
                    </c:forEach>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>