<%--
  Created by IntelliJ IDEA.
  User: Diego's Dell PC
  Date: 5/5/2019
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/styleMain.css">
</head>
<body>
<div>
    <h1>Shopping Cart</h1>
    <table>
        <tr>
            <th>Quantity</th>
            <th>Name</th>
            <th>Description</th>
            <th>Product Image</th>
            <th>Price</th>
            <th>Total Amount</th>
            <th></th>
        </tr>
        <c:set var="totalCart" scope="session" value="0"/>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="hidden" name="productCode" value="<c:out value='${item.product.productID}'/>">
                        <input type="text" name="quantity" value="<c:out value="${item.quantity}"/>">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td><c:out value="${item.product.prodName}"/></td>
                <td><c:out value="${item.product.prodDesc}"/></td>
                <td><img src="<c:out value="${item.product.prodPicLocation}"/>"></td>
                <td>$<c:out value="${item.product.prodPrice}"/></td>
                <td>$${item.total}</td>
                <c:set var="totalCart" value="${totalCart+item.total}"></c:set>
                <td><form action="cart" method="post">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productCode" value="<c:out value='${item.product.productID}'/>">
                    <input type="hidden" name="quantity" value="0">
                    <input type="submit" value="Remove Item">
                </form></td>
            </tr>
        </c:forEach>
        <tr>
           <td colspan="7" align="center"> Cart Total:$ <c:out value="${totalCart}"></c:out> </td>
        </tr>
    </table><br><br>
    <form action="store.jsp">
        <input type="hidden" name="password" value="admin"/>
        <input type="submit" value="Continue Shopping">
    </form>
</div>
</body>
</html>
