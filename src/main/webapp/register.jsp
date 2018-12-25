<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 12/25/18
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <p>
        <font color="red">${errorMessage}</font>
    </p>
    <h1>Sign Up</h1>

    <form action="register" method="post">
        Login <input type="text" name="username"/>
        <br>
        <br>
        Password <input type="password" name="password"/>
        <br>
        <input type="submit" value="Register"/>
    </form>
</div>
</body>
</html>
