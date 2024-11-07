<html>
<head>
    <title>Ticket #<c:out value="${ticketId}"/></title>
</head>
<body>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h1>Ticket Post</h1>
    <h2>Name: <c:out value="${ticket.name}"/></h2>
    <h2>Subject: <c:out value="${ticket.subject}"/></h2>
    <p>Summary: <c:out value="${ticket.ticketSummary}"/></p>
    <c:if test="${ticket.hasImage()}">
        <a href="<c:url value='/ticket/${ticketId}/attachments/${ticket.attachments.name}' />">
            <c:out value="${ticket.attachments.name}"/></a>
    </c:if>
    <br><a href="ticket">Return to ticket list</a>
</body>
</html>
