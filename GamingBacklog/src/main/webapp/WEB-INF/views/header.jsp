<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index"><h3>GAMING BACKLOG</h3></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <c:set var="path" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <div class="collapse navbar-collapse" id="navbarColor03">
        <c:choose>
            <c:when test="${path eq '/index'}">
                <c:set var="a1" value="active"/>
            </c:when>
            <c:when test="${(path eq '/backlog') or (path eq '/addToBacklog')}">
                <c:set var="a2" value="active"/>
            </c:when>
            <c:when test="${(path eq '/otherBacklogs') or (path eq '/otherBacklog')}">
                <c:set var="a3" value="active"/>
            </c:when>
            <c:when test="${path eq '/filter'}">
                <c:set var="a4" value="active"/>
            </c:when>
        </c:choose>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${a1}">
                <a class="nav-link" href="index">Home</a>
            </li>
            <li class="nav-item ${a2}">
                <a class="nav-link" href="backlog">Your backlog</a>
            </li>
            <li class="nav-item ${a3}">
                <a class="nav-link" href="otherBacklogs">Others backlogs</a>
            </li>
            <li class="nav-item ${a4}">
                <a class="nav-link" href="filter">Games filter</a>
            </li>
        </ul>
        <div class="navbar-nav mr-auto">
            <div class="navbar-item">Logged in as <b>${sessionScope.user}</b></div></div>
        <div class="navbar-nav mr-auto">
            <a href="login" class="navbar-item">Logout</a></div>
        <form class="form-inline my-2 my-lg-0" action="search" method="post">
            <input class="form-control mr-sm-2" type="text" name="query" placeholder="Game name">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Find a game</button>
        </form>
    </div>
</nav>