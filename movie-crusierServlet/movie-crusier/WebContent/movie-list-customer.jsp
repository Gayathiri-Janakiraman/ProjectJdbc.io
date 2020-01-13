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
		<div class="home">Movie Cruiser</div>
		<img height="20px" width="30px"
			src="images/movie.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="content">
		<h1>Favorites</h1>
		<c:if test="${addtofavoritesstatus}">
			<div class="notification">Movie added to favorites Successfully</div>
		</c:if>
		<table>
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${movie}" var="movie">
				<tr>
					<td>${movie.title}</td>
					<td>$<fmt:formatNumber type="currency"
							pattern="#,##,##,##,###.00" value="${movie.gross}" /></td>
					<td>${movie.genre}</td>
					<td><c:choose>
							<c:when test="${movie.hasteaser eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a class="fcolor"
						href="AddToFavorites?movielistId=${movie.id}">Add to Favorites</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>
</body>
</html>