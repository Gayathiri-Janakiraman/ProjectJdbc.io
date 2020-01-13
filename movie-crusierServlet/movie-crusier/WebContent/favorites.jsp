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
<body onload="addcolumn()">
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img height="20px" width="30px"
			src="images/movie.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>


	<div class="content">
		<h1>Favorites</h1>
		<c:if test="${deletefavoritesstatus}">
			<div class="notification">Movie removed from favorites
				Successfully</div>
		</c:if>
	</div>
	<span id="span" class="line"></span>
	<table id="table_id">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${movie.movieList}" var="movie">
			<tr>
				<td>${movie.title}</td>
				<td>$<fmt:formatNumber type="currency"
						pattern="#,##,##,##,###" value="${movie.gross}" /></td>
				<td>${movie.genre}</td>
				<td><a href="RemoveFavorites?movielistId=${movie.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td class="total">No of Favorites:  ${movie.total}</td>
			
		</tr>
	</table>
	<div class="footer">
		<p>Copyright © 2019</p>
	</div>

</body>
</html>