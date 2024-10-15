<html>
<head>
    <title>Create new Ticket</title>
</head>
<body>
    <h2>Create Ticket</h2>
    <form method="POST" action="ticket" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create">

        <h3>Name:</h3>
        <input type="text" name="name"><br><br>

        <h3>Subject:</h3>
        <input type="text" name="subject"><br><br>

        <h3>Summary:</h3>
        <textarea name="body" rows="25" cols="100"></textarea><br><br>

        <b>Attachment</b><br>
        <input type="file" name="file1"><br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
