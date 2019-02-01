<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Index</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <BR><BR>
    <h3 class="text-center">Random game of the moment:</h3>
    <BR><BR>
    <div class="col-lg-12">
        <div class="bs-component">
                <div class="card mb-12">
                    <h3 class="card-header">${game.name}
                        <c:if test="${game.gbId!=0}">
                        <a href="/addToBacklog?gbId=${game.gbId}">
                            <button class="btn btn-info float-right">Add to backlog</button></a>
                        </c:if></h3>
                    <c:if test="${game.gbId!=0}">
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
                    </c:if>
                    <div class="card-body">
                        <c:if test="${game.gbId!=0}">
                        <a href="/details?gbId=${game.gbId}">
                            <button class="btn btn-primary float-left">Game details</button></a>
                        </c:if>
                        <a href="/index">
                            <button class="btn btn-primary float-right">Reroll</button></a>
                    </div>
                </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
