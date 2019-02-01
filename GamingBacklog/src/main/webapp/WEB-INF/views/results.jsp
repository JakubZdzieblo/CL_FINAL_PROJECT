<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Results</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <BR><BR>
    <h3 class="text-center">Search results:</h3>
    <BR><BR>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Game title</th>
            <th scope="col">Short info</th>
            <th scope="col" style="min-width: 150px">Release date</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="gameDTO">
        <tr>
            <th scope="row">${gameDTO.name}</th>
            <td>${gameDTO.deck}</td>
            <td>${fn:substring(gameDTO.original_release_date, 0, 10)}</td>
            <td><a href="/details?gbId=${gameDTO.id}">
                <button type="button" class="btn btn-secondary">Details</button></a>
            </td>
            <td>
                <a href="/addToBacklog?gbId=${gameDTO.id}">
                    <button class="btn btn-primary float-right">Save</button></a>
            </td>
        </tr>
        </c:forEach></tbody></table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
