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
<div class="container-fluid">

<h1>Kid Friendly STL</h1>

<br />
<p>
	<a class="btn btn-default btn-lg" href="add-business-form.jsp" role="button">Add New Listing</a>
	<button type="button" class="btn btn-default btn-lg">Search Listings</button>
</p>
<br />

<table class="table table-hover">
	<thead>
	<tr>
		<th colspan="2">Business</th>
		<th>Categories</th>
		<th>Age Ranges</th>
		<th> </th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="currentBusiness" items="${BUSINESS_LIST}" >
					
		<!-- view link for each business -->
		<c:url var="viewLink" value="FriendlyControllerServlet">
			<c:param name="command" value="VIEW" />
			<c:param name="businessID" value="${currentBusiness.id}" />
		</c:url>
					
		<!-- update link for each business -->
		<c:url var="updateLink" value="FriendlyControllerServlet">
			<c:param name="command" value="LOAD" />
			<c:param name="businessID" value="${currentBusiness.id}" />
		</c:url>
					
		<!-- delete link for each business -->
		<c:url var="deleteLink" value="FriendlyControllerServlet">
			<c:param name="command" value="DELETE" />
			<c:param name="businessID" value="${currentBusiness.id}" />
		</c:url>
		
	<tr>
		<!-- BUSINESS -->
		<td>
			<address>
			<strong>${currentBusiness.name}</strong><br />
			${currentBusiness.address}<br />
			${currentBusiness.city}, 
			${currentBusiness.state} 
			${currentBusiness.zip}
			<br /><br />
			<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>  
				${currentBusiness.phone}<br />
			<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>  
				<a href="${currentBusiness.website}">website</a>
			</address>
		</td>
		
		<!-- ACTIONS -->
		<td>
			<a class="btn btn-default" href="${viewLink}" role="button">view more...</a>
			<br /><br />
			<a class="btn btn-default" href="${updateLink}" role="button">update listing</a>
		</td>
		
		<!-- CATEGORIES -->
		<td>
		<small>
			<c:forEach var="currentCategory" items="${CATEGORY_LIST}">
				<c:if test="${currentCategory.businessID == currentBusiness.id}">
				
				<ul class="list-group">
				<c:choose>
					<c:when test="${currentCategory.activeLife == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Active Life</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Active Life</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.artsEntertainment == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Arts & Entertainment</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Arts & Entertainment</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.education == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Education</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Education</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.foodRestaurant == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Food & Restaurants</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Food & Restaurants</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.healthMedical == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Health & Medical</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Health & Medical</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.hotelTravel == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Hotels & Travel</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Hotels & Travel</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.publicServiceGovernment == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Public Services</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Public Services</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.religious == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Religious</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Religious</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentCategory.shopping == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Shopping</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Shopping</li>
					</c:otherwise>
				</c:choose>
				
				</ul>
				</c:if>
			</c:forEach>
		</small>
		</td>
		
		<!-- AGE RANGES -->
		<td>
		<small>
			<c:forEach var="currentAgeRange" items="${AGE_LIST}">
				<c:if test="${currentAgeRange.businessID == currentBusiness.id}">
				
				<ul class="list-group">
				
				<c:choose>
					<c:when test="${currentAgeRange.allAges == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  All Ages</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">All Ages</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentAgeRange.baby == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Baby</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Baby</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentAgeRange.toddler == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Toddler</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Toddler</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentAgeRange.preschooler == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Preschooler</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Preschooler</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentAgeRange.gradeSchooler == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Grade Schooler</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Grade Schooler</li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${currentAgeRange.teen == true}">
						<li class="list-group-item list-group-item-success">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						  Teen</li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item">Teen</li>
					</c:otherwise>
				</c:choose>
				
				</ul>
				
				</c:if>
			</c:forEach>
		</small>
		</td>
		
		<!-- DELETE -->
		<td>
			<a class="btn btn-danger" href="${deleteLink}" role="button" 
			onclick="if (!(confirm('Are you sure you want to delete this business?'))) return false">DELETE</a>
		</td>
		
	</tr>
	</c:forEach>
	</tbody>	
</table>
</div>	
</body>
</html>