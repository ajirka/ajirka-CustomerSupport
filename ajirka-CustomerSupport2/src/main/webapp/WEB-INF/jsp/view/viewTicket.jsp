
<html>
<head>
    <title>Ticket #<c:out value="${ticketId}"/></title>
</head>
<body>
    <h1>Ticket Post</h1>
    <h2>Name: <c:out value="${ticket.name}"/></h2>
    <h2>Subject: <c:out value="${ticket.subject}"/></h2>
    <p>Summary: <c:out value="${ticket.ticketSummary}"/></p>
    <c:if test="${ticket.hasImage()}">
        <a href="<c:url value='/ticket' >
            <c:param name='action' value='download' />
            <c:param name='ticketId' value='${ticketId}' />
            <c:param name='attachment' value='${ticket.attachment.name}' />
        </c:url>"><c:out value="${ticket.attachment.name}"/></a>
    </c:if>
    <br><a href="ticket">Return to ticket list</a>


</body>
</html>
