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
	<div class="row">
<!-- HEADING -->
  		<div class="col-sm-12">
			<h1>Kid Friendly STL</h1>
		</div>
	</div>
<!-- Generate Links -->
	<c:url var="updateLink" value="FriendlyControllerServlet">
		<c:param name="command" value="LOAD" />
		<c:param name="businessID" value="${THE_BUSINESS.id}" />
	</c:url>
	<c:url var="deleteLink" value="FriendlyControllerServlet">
		<c:param name="command" value="DELETE" />
		<c:param name="businessID" value="${THE_BUSINESS.id}" />
	</c:url>
<!-- BUTTONS -->
	<div class="row">
		<div class="col-sm-12">
			<a class="btn btn-default" href="${pageContext.request.contextPath}/" role="button" >home</a> 
			<button class="btn btn-default"  type="button" name="back" onclick="history.back()">back</button>
			<a class="btn btn-default" href="${updateLink}" role="button">update</a>
			<a class="btn btn-danger" href="${deleteLink}" role="button" 
			onclick="if (!(confirm('Are you sure you want to delete this business?'))) return false">DELETE</a>
		</div>
	</div>
	<div class="row">
<!-- SUBHEADING -->	
		<div class="col-sm-6">
			<h3>${THE_BUSINESS.name}</h3>
		</div>
		<div class="col-sm-6 text-center">
			<h3>
				<c:choose>
					<c:when test="${THE_BUSINESS.rating == 0 }">
						<small>NOT RATED</small>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${THE_BUSINESS.rating}">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="${5 - THE_BUSINESS.rating}">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
	</div>
	<div class="row">
<!-- CONTACT INFORMATION -->
		<div class="col-sm-12">
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
	 		<div class="col-sm-3">
				<h4>Categories</h4>
				<ul class="list-unstyled">
					<li><span class="${BUSINESS_CATEGORY.activeLife == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Active Life</li>
					<li><span class="${BUSINESS_CATEGORY.artsEntertainment == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Arts & Entertainment</li>
					<li><span class="${BUSINESS_CATEGORY.education == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Education</li>
					<li><span class="${BUSINESS_CATEGORY.foodRestaurant == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Food & Restaurants</li>
					<li><span class="${BUSINESS_CATEGORY.healthMedical == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Health/ Medical</li>
					<li><span class="${BUSINESS_CATEGORY.hotelTravel == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Hotels & Travel</li>
					<li><span class="${BUSINESS_CATEGORY.publicServiceGovernment == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Public Services/ Government</li>
					<li><span class="${BUSINESS_CATEGORY.religious == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Religious</li>
					<li><span class="${BUSINESS_CATEGORY.shopping == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Shopping</li>
				</ul>
			</div>
<!-- BUSINESS_AGE_RANGE -->
  			<div class="col-sm-3">
				<h4>Age Ranges</h4>
				<ul class="list-unstyled">
					<li><span class="${BUSINESS_AGE_RANGE.baby == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Baby</li>
					<li><span class="${BUSINESS_AGE_RANGE.toddler == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Toddler</li>
					<li><span class="${BUSINESS_AGE_RANGE.preschooler == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Preschooler</li>
					<li><span class="${BUSINESS_AGE_RANGE.gradeSchooler == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Grade Schooler</li>
					<li><span class="${BUSINESS_AGE_RANGE.teen == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Teen</li>
				</ul>
			</div>				
<!-- KID_FRIENDLY_DETAIL - Best Times -->
  			<div class="col-sm-3">
				<h4>Best Times</h4>
				<ul class="list-unstyled">
					<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.morning == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Morning</li>
					<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Afternoon</li>
					<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.evening == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Evening</li>
				</ul>
			</div>
<!-- KID_FRIENDLY_DETAIL -->
  			<div class="col-sm-3">
  				<div class="row">
					<h4>Lots of Families?</h4>
					<ul class="list-unstyled">
						<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes!</li>
						<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Nope</li>
					</ul>
				</div>
				<br />
  				<div class="row">
					<h4>Kid's Free or Discount?</h4>
					<ul class="list-unstyled">
						<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes!</li>
						<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> None</li>
					</ul>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-sm-12">
				<h4>Details</h4>
				<div class="panel panel-default">
				  <div class="panel-body">
				    ${empty BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail ? 'No further details listed' : BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}
				  </div>
				</div>
  			</div>
  		</div>
  		<br /><br /><br />	
	</div>
</body>
</html>