<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 12/25/18
  Time: 8:32 PM
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
    <h1>Sign In</h1>
    <form action="login" method="post">
        Please enter your username <br> <input type="text" name="username"/>
        <br>
        <br>
        Please enter your password <br> <input type="password" name="password"/> <input
            type="submit" value="Login"/>
    </form>

    <br>

    <h2>Or register</h2>

    <form name="Sign Up" action="register" method='get'>
        <input type='submit' value='Sign Up'/>
    </form>
</div>
</body>
</html>