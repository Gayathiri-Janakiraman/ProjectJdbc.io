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
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Crusier</div>
		<img height="20px" width="30px"
			src="images/movie.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="content">
		<h1>Favorites</h1>
	</div>
	<div class="customer-list">
		<p>
			No Items in Favorites. Use 'Add to Favorites'option in <a
				class="mcolor" href="ShowMovieListCustomer">Movie List</a>
		</p>
	</div>
	<div class="footer">
		<p>Copyright © 2019</p>
	</div>
</body>
</html>