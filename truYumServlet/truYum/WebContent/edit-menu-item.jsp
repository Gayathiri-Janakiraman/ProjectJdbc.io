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
<title>Edit Menu Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/logo.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h1>Edit Menu Item</h1>
	<div class="body-content-colour">
	<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
		name="MenuItemForm" method="post">

		<div class="form-field-spacing">
			<label for="name">Name</label> <input type="text"
				class="text-box  text-box-title" name="name" 
				value="${menuItem.name}">
		</div>

		<div class="form-field-spacing">
			<label for="price">Price(Rs.)</label><br> <input type="text"
				class="text-box" name="price" id="price" value="${menuItem.price}">
		</div>

		<div class="form-field-spacing">
			<label for="instock">Active</label><br> <input class="radio"
				type="radio" name="instock" id="" value="yes"
				<c:if test="${menuItem.active}">checked</c:if>>Yes <input
				class="radio" type="radio" name="instock" id="" value="No"
				<c:if test="${!menuItem.active}">checked</c:if>>No

		</div>


		<div class="form-field-spacing">
			<label for="dateofLaunch">Date of Launch</label><br> <input
				type="text" class="text-box" name="dateofLaunch"
				value="<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateofLaunch}"/>">

		</div>

		<div class="form-field-spacing">
			<label for="category">Category</label> <select name="category"
				class="dropdown">
				<option value="${menuItem.category}">${menuItem.category}</option>
				<option value="Starters">Starters</option>
				<option value="Main Course">Main Course</option>
				<option value="Dessert">Dessert</option>
				<option value="Drinks">Drinks</option>
			</select>
		</div>
		<div>
			<div class="form-field-spacing">
					<label for="Free Delivery">FreeDelivery</label> <input
						type="checkbox" name="freeDelivery"
						<c:if test="${menuItem.freeDelivery eq 'true' }">checked</c:if>>
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
			</div>
		</div>

		<div class="form-field-spacing">
			<input type="submit" class="button success-button" value="save">
		</div>
	</form>
</div>
	<div class="footer">
		<p>Copyright © 2019</p>
	</div>
</body>
</html>