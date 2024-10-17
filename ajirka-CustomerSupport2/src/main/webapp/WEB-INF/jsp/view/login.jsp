<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    Login To Access Website<br>
    <c:if test="${loginFailed == true}">
        <b><c:out value="The username/password is incorrect"></c:out></b>
    </c:if>
    <form method="POST" action="<c:url value='/login'/>">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="LogIn">
    </form>
</body>
</html>
