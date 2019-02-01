<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/darkly/bootstrap.min.css" crossorigin="anonymous">
    <title>Comment</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
        <div class="row justify-content-md-center">
            <div class=col-lg-auto">
                <h4 class="text-center">Add your comment</h4>
                <form:form method="post" action="/comments/save" modelAttribute="comment">
                    <form:textarea path="text" placeholder="Comment" cols="80" rows="4"/><br>
                    <form:errors path="text" cssStyle="color: lightcoral"/><BR><BR>
                    <input type="hidden" name="gbId" value="${gbId}"/>
                    <form:button>SUBMIT</form:button>
                </form:form>
            </div></div>

</div>
<%@ include file="footer.jsp"%>
</body>
</html>

