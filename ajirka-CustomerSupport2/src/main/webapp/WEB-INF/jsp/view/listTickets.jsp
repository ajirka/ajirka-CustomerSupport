<html>
<head>
    <title>Ticket Posts</title>
</head>
<body>
    <h2>Ticket Posts</h2>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h2>Ticket Posts</h2>
    <a href="<c:url value='/ticket/create'/>">Create Ticket</a><br><br>
    <c:choose>
        <c:when test="${ticketDatebase.size() == 0}">
            <p>There are no tickets yet.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${ticketDatabase}">
                Ticket #<c:out value="${ticket.key}"/>:
                <a href="<c:url value='/ticket/view/${ticket.key}'/>">
                <c:out value="${ticket.value.name}"/></a><br>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
