<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
<title>Menu Item List Customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/logo.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="content">
		<h1>Menu Items</h1>
		<c:if test="${addCartStatus}">
			<div class="notification">Item added to Cart Successfully</div>
		</c:if>
		<table>
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItem}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>




						</c:choose></td>
					<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
							type="currency" pattern="#,##,##,##,###.00"
							value="${menuItem.price}" /></td>
					<td>${menuItem.category}</td>
					<td><a class="fcolor"
						href="AddToCart?menuItemId=${menuItem.id}">Add to cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>
</body>
</html>



