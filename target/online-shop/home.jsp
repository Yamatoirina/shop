<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 12/25/18
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/css/index.css" rel="stylesheet" type="text/css">
    <title>Home</title>
</head>
<body>

<h2>Home</h2>

<form name="Sign In" action="login" method='get'>
    <input type='submit' value='Sign In' />
</form>
<br>
<form name="Sign Up" action="register" method='get'>
    <input type='submit' value='Sign Up' />
</form>
<br>
<form name="Go shopping" action="shopping" method='get'>
    <input type='submit' value='Go shopping!'/>
</form>

</body>
</html>
