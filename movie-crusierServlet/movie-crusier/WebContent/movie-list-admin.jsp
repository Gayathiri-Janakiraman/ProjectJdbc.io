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
			href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="content">
		<h1>Movies</h1>
		</div>
		<table>
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${movie}" var="movie">
				<tr>
					<td>${movie.title}</td>
					<td>$<fmt:setLocale value="en_US"/> <fmt:formatNumber
							pattern="#,###,###,###" type="currency"
							value="${movie.gross}" /></td>
					<td><c:choose>
							<c:when test="${movie.active eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${movie.dateofLaunch}" /></td>
					<td>${movie.genre}</td>
					<td><c:choose>
							<c:when test="${movie.hasteaser eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a class="fcolor"
						href="ShowMovie?movielistId=${movie.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<p>Copyright © 2019</p>
		</div>
</body>
</html>