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

	<title>${THE_BUSINESS.name}</title>

</head>
<body>
	<div class="container-fluid">

		<h1>Kid Friendly STL</h1>

		<br />

		<!-- Buttons -->

		<!-- home link -->
		<c:url var="homeLink" value="FriendlyControllerServlet">
			<c:param name="command" value="LIST" />
		</c:url>

		<!-- update link for business -->
		<c:url var="updateLink" value="FriendlyControllerServlet">
			<c:param name="command" value="LOAD" />
			<c:param name="businessID" value="${THE_BUSINESS.id}" />
		</c:url>
					
 		<!-- delete link for business -->
		<c:url var="deleteLink" value="FriendlyControllerServlet">
			<c:param name="command" value="DELETE" />
			<c:param name="businessID" value="${THE_BUSINESS.id}" />
		</c:url>
		
		<a class="btn btn-default" href="${homeLink}" role="button" >home</a> 
		<a class="btn btn-default" href="${updateLink}" role="button">update</a>
		<a class="btn btn-danger" href="${deleteLink}" role="button" 
		onclick="if (!(confirm('Are you sure you want to delete this business?'))) return false">DELETE</a>
		
		<hr>
		<h2>${THE_BUSINESS.name}</h2>
		<hr>
		<h3>
			<small> ${THE_BUSINESS.address}, ${THE_BUSINESS.city},
				${THE_BUSINESS.state} ${THE_BUSINESS.zip} | <span
				class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
				${THE_BUSINESS.phone} | <span class="glyphicon glyphicon-globe"
				aria-hidden="true"></span> <a href="${THE_BUSINESS.website}">website</a>
			</small>

		</h3>
		<br /> <br />
		<!-- BUSINESS_CATEGORY - Table -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Categories</strong>
			</div>
			
			<!-- Table -->
			<table class="table table-condensed table-bordered">
				<tbody>
					<tr>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.activeLife == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Active Life</td>
							</c:when>
							<c:otherwise>
								<td>Active Life</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.artsEntertainment == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Arts & Entertainment</td>
							</c:when>
							<c:otherwise>
								<td>Arts & Entertainment</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.education == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Education</td>
							</c:when>
							<c:otherwise>
								<td>Education</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.foodRestaurant == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Food & Restaurant</td>
							</c:when>
							<c:otherwise>
								<td>Food & Restaurant</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.healthMedical == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Health & Medical</td>
							</c:when>
							<c:otherwise>
								<td>Health & Medical</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.hotelTravel == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Hotel & Travel</td>
							</c:when>
							<c:otherwise>
								<td>Hotel & Travel</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when
								test="${BUSINESS_CATEGORY.publicServiceGovernment == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Public Services</td>
							</c:when>
							<c:otherwise>
								<td>Public Services</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.religious == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Religious</td>
							</c:when>
							<c:otherwise>
								<td>Religious</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_CATEGORY.shopping == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Shopping</td>
							</c:when>
							<c:otherwise>
								<td>Shopping</td>
							</c:otherwise>
						</c:choose>
					</tr>

				</tbody>
			</table>
		</div>

		<!-- BUSINESS_AGE_RANGE -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Age Ranges</strong>
			</div>
			
			<!-- Table -->
			<table class="table table-condensed table-bordered">
				<tbody>
					<tr>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.allAges == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> All Ages</td>
							</c:when>
							<c:otherwise>
								<td>All Ages</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.baby == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Baby</td>
							</c:when>
							<c:otherwise>
								<td>Baby</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.toddler == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Toddler</td>
							</c:when>
							<c:otherwise>
								<td>Toddler</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.preschooler == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Preschooler</td>
							</c:when>
							<c:otherwise>
								<td>Preschooler</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.gradeSchooler == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Grade Schooler</td>
							</c:when>
							<c:otherwise>
								<td>Grade Schooler</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_AGE_RANGE.teen == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Teen</td>
							</c:when>
							<c:otherwise>
								<td>Teen</td>
							</c:otherwise>
						</c:choose>

					</tr>
				</tbody>
			</table>
		</div>

		<!-- KID_FRIENDLY_DETAIL - Best Times -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Best Times</strong>
			</div>
			
			<!-- Table -->
			<table class="table table-condensed table-bordered">
				<tbody>
					<tr>

						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.allDay == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> All Day</td>
							</c:when>
							<c:otherwise>
								<td>All Day</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.morning == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Morning</td>
							</c:when>
							<c:otherwise>
								<td>Morning</td>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Afternoon</td>
							</c:when>
							<c:otherwise>
								<td>Afternoon</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.evening == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Evening</td>
							</c:when>
							<c:otherwise>
								<td>Evening</td>
							</c:otherwise>
						</c:choose>

					</tr>
				</tbody>
			</table>
		</div>

		<!-- KID_FRIENDLY_DETAIL -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Kid Friendly Details</strong>
			</div>
			
			<!-- Table -->
			<table class="table table-condensed table-bordered">
				<tbody>
					<tr>

						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Lots of Families</td>
							</c:when>
							<c:otherwise>
								<td class="danger"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span> Lots of Families</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true}">
								<td class="success"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span> Kid's Free/ Discount</td>
							</c:when>
							<c:otherwise>
								<td class="danger"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span> Kid's Free/ Discount</td>
							</c:otherwise>
						</c:choose>
					
						<td>Details: ${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>