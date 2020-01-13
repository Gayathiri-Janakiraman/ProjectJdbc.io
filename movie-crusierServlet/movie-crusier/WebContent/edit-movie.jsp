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
		<img src="images/movie.png"> <a
			href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="content"></div>
	<h1>Edit Movies</h1>
	<form action="EditMovie" onsubmit="return validateform()"
		name="editMovie" method="post">
		<div class="form-field-spacing">
			<label for="title">Title</label> <input type="text"
				class="text-box  text-box-title" name="title" value="${movie.title}">
		</div>
		<div class="form-field-spacing">
			<label for="gross">Gross($)</label><br> <input type="text"
				class="text-box" name="gross" id="gross" value="${movie.gross}">
		</div>
		<div class="form-field-spacing">
			<label for="active">Active</label><br> <input class="radio"
				type="radio" name="active" id="" value="yes"
				<c:if test="${movie.active}">checked</c:if>>Yes <input
				class="radio" type="radio" name="active" id="" value="No"
				<c:if test="${!movie.active}">checked</c:if>>No
		</div>
		<div class="form-field-spacing">
			<label for="dateofLaunch">Date of Launch</label><br> <input
				type="text" class="text-box" name="dateofLaunch"
				value="<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateofLaunch}"/>">
		</div>
		<div class="form-field-spacing">
			<label for="genre">Genre</label> <br> <select name="genre"
				class="dropdown">
				<option value="${movie.genre}">${movie.genre}</option>
				<option value="Science Fiction">Science Fiction</option>
				<option value="Superhero">Superhero</option>
				<option value="Romance">Romance</option>
				<option value="Comedy">Comedy</option>
				<option value="Adventure">Adventure</option>
				<option value="Thriller">Thriller</option>
			</select>
		</div><br>
		<div class="form-field-spacing">
			<label for="Has Teaser">Has Teaser</label>
			<c:if test="${movie.hasteaser}">
				<input type="checkbox" name="hasteaser" checked>
			</c:if>
			<c:if test="${!movie.hasteaser}">
				<input type="checkbox" name="hasteaser">
			</c:if>
		</div>
		<div>
			<input type="hidden" name="id" value="${movie.id}">
		</div>
		<div class="form-field-spacing">
			<input type="submit" class="button success-button" value="save">
		</div>
	</form>
	<div class="footer">
		<p>Copyright © 2019</p>
	</div>
</body>
</html>