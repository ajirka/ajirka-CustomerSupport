<html>
<head>
    <title>Create new Ticket</title>
</head>
<body>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h2>Create Ticket</h2>

    <form:form method="POST" action="create" modelAttribute="ticket" enctype="multipart/form-data">
        <form:label path="name">Name:</form:label><br>
        <form:input path="name"/><br><br>
        <form:label path="subject">Subject:</form:label><br>
        <form:input path="subject"/><br><br>
        <form:label path="ticketSummary">Body:</form:label><br>
        <form:textarea path="ticketSummary" rows="25" cols="100"/><br><br>
        <b>Attachment</b><br>
        <form:input path="attachments" type="file"/>
        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
