<%--
  Created by IntelliJ IDEA.
  User: Diego's Dell PC
  Date: 5/04/2019
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Store Products</title>
  <link rel="stylesheet" href="css/styleMain.css">
</head>

<body>
<h1>Main Website</h1>
<div>
  <h1>Welcome to my website</h1>
    <form action="store.jsp">
        <input type="hidden" name="password" value="admin"/>
        <input type="submit" value="Store">
    </form>
</div>
<div>
    <h1>Login App using HttpSession</h1>
   <button><a href="login.html">Login</a></button>
    <%--<form action="store" method="get">--%>
        <%--<input type="hidden" name="store" value="logout">--%>
        <%--<input type="submit" value="Logout">--%>
    <%--</form>--%>
    <%--<form action="store" method="get">--%>
        <%--<input type="hidden" name="store" value="goToStore">--%>
        <%--<input type="submit" value="Go To Store">--%>
    <%--</form>--%>
</div>
<div>
    <h1>Login Through Filter</h1>
    <form action="store.jsp">
        <input type="hidden" name="store" value="goToStore">
        Name:<input type="text" name="name"/><br/>
        Password:<input type="password" name="password"/><br/>
        <input type="submit" value="login">
    </form>
</div>
<div>
    <h1> Cookies </h1>

</div>
</body>
</html>
