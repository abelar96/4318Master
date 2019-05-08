<%--
  Created by IntelliJ IDEA.
  User: Diego's Dell PC
  Date: 5/7/2019
  Time: 8:24 PM
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

<div>
    <h1>Store Products</h1>
    <button><a href="index.jsp">Return to main page</a></button>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Product Description</th>
            <th>Product Price</th>
            <th>Product Image</th>
            <th></th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.prodName}"/></td>
                <td><c:out value="${product.prodDesc}"/></td>
                <td><c:out value="$ ${product.prodPrice}"/></td>
                <td><img src="<c:out value="${product.prodPicLocation}"/>"></td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="hidden" name="productCode" value="${product.productID}">
                        <input type="submit" value="Add to Cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table><br><br>
</div>
</body>
</html>
