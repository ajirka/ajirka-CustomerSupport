<c:set var="now" value="<%=System.currentTimeMillis()%>" />
<html>
<head>
    <title>Session Window</title>
</head>
<body>
    <a href="<c:url value='/login'>
        <c:param name='logout'/>
        </c:url>">LogOut</a>
    <h2>Sessions</h2>
    Total of Active Sessions: <c:out value="${numSessions}"/>
    <ul>
        <c:forEach items="${sessionList}" var="s">
            <li><c:out value="${s.id} - ${s.getAttribute('username')} - Last Active ${(now-s.getLastAccessedTime())/1000} seconds ago"/></li>
        </c:forEach>
    </ul>
</body>
</html>
