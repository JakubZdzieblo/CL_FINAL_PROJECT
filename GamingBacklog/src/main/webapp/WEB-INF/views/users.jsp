<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <BR><BR>
    <h3 class="text-center">Choose a user to see their backlog</h3>
    <BR><BR>
    <div class="row justify-content-md-center">
        <div class="col col-lg-2">
            <table class="table table-hover">
                <tbody>
                <c:forEach items="${users}" var="user">
                <tr>
                    <td class="text-center"><a href="otherBacklog?id=${user.id}">
                        <button type="button" class="btn btn-secondary">${user.name}</button>
                    </a>
                    </td>
                </tr>
                </c:forEach></tbody></table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
