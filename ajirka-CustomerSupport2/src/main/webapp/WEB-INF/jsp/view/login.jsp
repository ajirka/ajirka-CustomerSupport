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
    <form:form method="POST" action="login" modelAttribute="loginForm">
        <form:label path="username">Username:&nbsp;</form:label>
        <form:input path="username"/><br><br>
        <form:label path="password">Password:&nbsp;</form:label>
        <form:password path="password"/><br><br>
        <input type="submit" value="Log In">
    </form:form>
</body>
</html>
