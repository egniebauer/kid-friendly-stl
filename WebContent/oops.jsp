<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link type="text/css" rel="stylesheet"
		href="css/bootstrap-theme.min.css" />
	<link type="text/css" rel="stylesheet"
		href="css/bootstrap-theme.min.css.map" />
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<title>OOPS...</title>

</head>
<body>
	<div class="container">

		<h1>OOPS...</h1>

		<br />

		<!-- Buttons -->

		<!-- home link -->
		<c:url var="homeLink" value="FriendlyControllerServlet">
			<c:param name="command" value="LIST" />
		</c:url>
		
		<a class="btn btn-default" href="${homeLink}" role="button" >home</a> 
		<a class="btn btn-default" href="add-business-form.jsp" role="button" >add</a> 
		
		<br /> <br />
		
		<p><b>We encountered a problem:</b></p>
		<br />
		<p>${ERROR_MESSAGE}</p>
		
	</div>
</body>
</html>