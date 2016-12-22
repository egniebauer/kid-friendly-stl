<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css" />         
	<link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css.map" />         
	<link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css" />         
	<link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css.map" />         
	<script src="js/bootstrap.min.js"></script>
	
	<title>Kid Friendly STL</title>
	
</head>
<body>
<div class="container">

	<h1>Kid Friendly STL</h1>

	<br />
	
	<!-- Buttons -->
	<p>
		<a class="btn btn-default" href="add-business-form.jsp" role="button">Add New Listing</a>
		<button type="button" class="btn btn-default">Search Listings</button>
	</p>
	
	<br />

	<!-- Results Table -->
	<table class="table table-hover table-striped table-bordered">
		<tbody>
		
		<c:forEach var="currentBusiness" items="${BUSINESS_LIST}" >
						
			<!-- view link for each business -->
			<c:url var="viewLink" value="FriendlyControllerServlet">
				<c:param name="command" value="VIEW" />
				<c:param name="businessID" value="${currentBusiness.id}" />
			</c:url>
			
		<tr>
			<td>
				<a href="${viewLink}"><h4>${currentBusiness.name}</h4></a>
			</td>
		</tr>
		
		</c:forEach>
		
		</tbody>	
	</table>
</div>	
</body>
</html>