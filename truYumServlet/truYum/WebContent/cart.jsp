<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<title>Cart</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/logo.png"> <a href="cart.jsp">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="content">
		<h1>Cart</h1>
		<c:if test="${deletecartstatus}">
			<div class="notification">Item removed from Cart Successfully</div>
		</c:if>
		<table id="table_id">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
			</tr>
			<c:forEach items="${cart.menuItemList}" var="menuItem">
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
					<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td class="total">Total</td>
				<td class="total">Rs.<fmt:formatNumber type="currency"
						value="${cart.total}" pattern="#,##,##,##,###.00" />
				</td>
			</tr>
		</table>
		<div class="footer">
			<p>Copyright © 2019</p>
		</div>
	</div>
</body>
</html>






