<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Filter</title>
</head>
<body>
<%@ include file="header.jsp"%>
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
<%@ include file="footer.jsp"%>
</body>
</html>
