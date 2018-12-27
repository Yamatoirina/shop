<%--
  Created by IntelliJ IDEA.
  User: hillel
  Date: 27.12.18
  Time: 19:46
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
    <h1>Add Product</h1>

    <form action="name" method="post">
        Name <input type="text" name="productname"/>
        <br>
        <br>
        Price <input type="text" name="price"/>
        <br>
        Quantity <input type="text" name="quantity"/>
        <br>
        Barcode <input type="text" name="barcode"/>
        <br>
        <input type="submit" value="Add"/>
    </form>
</div>
</body>
</html>