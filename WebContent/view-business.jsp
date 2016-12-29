<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" /> <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css.map" /> <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" /> <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<title>${THE_BUSINESS.name}</title>
</head>
<body>
<div class="container">
<!-- HEADING -->
	<h1>Kid Friendly STL</h1>
	<br />
<!-- Generate Links -->
	<c:url var="homeLink" value="FriendlyControllerServlet">
		<c:param name="command" value="LIST" />
	</c:url>
	<c:url var="updateLink" value="FriendlyControllerServlet">
		<c:param name="command" value="LOAD" />
		<c:param name="businessID" value="${THE_BUSINESS.id}" />
	</c:url>
	<c:url var="deleteLink" value="FriendlyControllerServlet">
		<c:param name="command" value="DELETE" />
		<c:param name="businessID" value="${THE_BUSINESS.id}" />
	</c:url>
<!-- BUTTONS -->
	<div>
		<a class="btn btn-default" href="${homeLink}" role="button" >home</a> 
		<a class="btn btn-default" href="${updateLink}" role="button">update</a>
		<a class="btn btn-danger" href="${deleteLink}" role="button" 
		onclick="if (!(confirm('Are you sure you want to delete this business?'))) return false">DELETE</a>
	</div>
<!-- SUBHEADING -->	
	<h3>${THE_BUSINESS.name}</h3>
		<div class="row">
<!-- CONTACT INFORMATION -->
  			<div class="col-md-12">
				<address>
				${THE_BUSINESS.address}<br>
				${THE_BUSINESS.city}, ${THE_BUSINESS.state} ${THE_BUSINESS.zip}<br>
				<br>
				<abbr title="Phone"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></abbr> ${String.valueOf(THE_BUSINESS.phone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3")}<br>
				<abbr title="Website"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span></abbr> <a href="${THE_BUSINESS.website}">${empty THE_BUSINESS.website ? '' : 'website'}</a>
				</address>
  			</div>
  		</div>
  		<div class="row">
<!-- BUSINESS_CATEGORY -->
	 		<div class="col-md-4">
				<h4>Categories</h4>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.activeLife == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Active Life</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Active Life</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.artsEntertainment == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Arts & Entertainment</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Arts & Entertainment</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.education == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Education</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Education</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.foodRestaurant == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Food & Restaurants</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Food & Restaurants</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.healthMedical == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Health/ Medical</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Health/ Medical</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.hotelTravel == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Hotels & Travel</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Hotels & Travel</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.publicServiceGovernment == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Public Services/ Government</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Public Services/ Government</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.religious == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Religious</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Religious</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_CATEGORY.shopping == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Shopping</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Shopping</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
<!-- BUSINESS_AGE_RANGE -->
  			<div class="col-md-4">
				<h4>Age Ranges</h4>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.allAges == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>All Ages</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> All Ages</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.baby == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Baby</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Baby</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.toddler == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Toddler</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Toddler</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.preschooler == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Preschooler</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Preschooler</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.gradeSchooler == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Grade Schooler</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Grade Schooler</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_AGE_RANGE.teen == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Teen</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Teen</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>				
<!-- KID_FRIENDLY_DETAIL - Best Times -->
  			<div class="col-md-4">
				<h4>Best Times</h4>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.allDay == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>All Day</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> All Day</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.morning == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Morning</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Morning</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Afternoon</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Afternoon</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.evening == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Evening</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Evening</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		<br />
		<div class="row">
<!-- KID_FRIENDLY_DETAIL -->
  			<div class="col-md-12">
				<h4>Kid Friendly Details</h4>
			</div>
			<div class="col-md-6">
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Lots of Families</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Lots of Families</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="col-md-6">
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true}">
							<li><span class="glyphicon glyphicon-check" aria-hidden="true"></span> <em>Kids Free/ Discount</em></li>
						</c:when>
						<c:otherwise>
							<li><span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span> Kids Free Discount</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-12">
				<ul class="list-unstyled">
					<dl>
						<dt>Details</dt>
						<dd>${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}</dd>
					</dl>
				</ul>
  			</div>
  		</div>	
	</div>
</body>
</html>