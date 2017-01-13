<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" /> <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css.map" /> <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" /> <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<title>${THE_BUSINESS.name}</title>
</head>
<body>
<div class="container">
<!-- HEADING -->
	<div class="row">
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
		<div class="col-sm-6">
			<h2>${THE_BUSINESS.name}</h2>
		</div>
		<div class="col-sm-6 text-center">
			<c:choose>
				<c:when test="${THE_BUSINESS.rating == 0 }">
					<h2><small>NOT RATED</small></h2>
				</c:when>
				<c:otherwise>
					<c:forEach begin="1" end="${THE_BUSINESS.rating}">
		   				<h2><span class="glyphicon glyphicon-star" aria-hidden="true"></span></h2>
					</c:forEach>
					<c:forEach begin="1" end="${5 - THE_BUSINESS.rating}">
		   				<h2><span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></h2>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
<!-- CONTACT INFORMATION -->
	<div class="row">
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
<!-- Section Heading - THE BASICS -->
	<div class="row">
		<div class="col-sm-12">
			<h2>The Basics</h2>
		</div>
	</div>
<!-- BUSINESS_CATEGORY -->
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-body">
			 		<div class="col-sm-3">
						<h5>Categories</h5>
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
						<h5>Age Ranges</h5>
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
						<h5>Best Times</h5>
						<ul class="list-unstyled">
							<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.morning == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Morning</li>
							<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Afternoon</li>
							<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.evening == true ? 'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Evening</li>
						</ul>
					</div>
	<!-- KID_FRIENDLY_DETAIL -->
			 		<div class="col-sm-3">
			 			<div class="row">
							<h5>Lots of Families?</h5>
							<ul class="list-unstyled">
								<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
								<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
							</ul>
						</div>
						<br />
			 			<div class="row">
							<h5>Kid's Free or Discount?</h5>
							<ul class="list-unstyled">
								<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
								<li><span class="${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- Section Heading - THE SPECIFICS -->
	<div class="row">
		<div class="col-sm-12">
			<h2>The Specifics</h2>
		</div>
	</div>
<!-- Restrooms -->
	<div class="row">
		<div class="col-sm-12">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="restroomsHeading">
						<h3 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#restrooms" aria-expanded="false" aria-controls="restrooms">
								Restrooms
							</a>
						</h3>
					</div>
				    <div id="restrooms" class="panel-collapse collapse" role="tabpanel" aria-labelledby="restrooms">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-4">
									<h5>Clean?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTROOM.clean == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_RESTROOM.clean == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h5>Toddler Safety Seat?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTROOM.toddlerSeat == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_RESTROOM.toddlerSeat == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h5>Obnoxious Hand Dryer?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTROOM.handDryer == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_RESTROOM.handDryer == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<h5>What's the changing table situation?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTROOM.womensRoom == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Women's Room</li>
										<li><span class="${BUSINESS_RESTROOM.mensRoom == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Men's Room</li>
										<li><span class="${BUSINESS_RESTROOM.familyRoom == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Family Room</li>
										<li><span class="${BUSINESS_RESTROOM.noChangingTable == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> NONE</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
<!-- Breastfeeding -->
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="breastfeedingHeading">
						<h3 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#breastfeeding" aria-expanded="false" aria-controls="breastfeeding">
								Breastfeeding
					        </a>
						</h3>
					</div>
					<div id="breastfeeding" class="panel-collapse collapse" role="tabpanel" aria-labelledby="breastfeeding">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-4">
									<h5>Clean?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_BREASTFEEDING.clean == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_BREASTFEEDING.clean == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h5>Are you comfortable breastfeeding here?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_BREASTFEEDING.comfortable == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_BREASTFEEDING.comfortable == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h5>Bottle Warmers?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_BREASTFEEDING.bottleWarmer == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_BREASTFEEDING.bottleWarmer == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<h5>Where are you popping out your boobs?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_BREASTFEEDING.lactationRoom == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Lactation Room</li>
										<li><span class="${BUSINESS_BREASTFEEDING.quietArea == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Quiet Area</li>
										<li><span class="${BUSINESS_BREASTFEEDING.grossOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Dirty Bathroom Stall</li>
										<li><span class="${BUSINESS_BREASTFEEDING.nonSpecificOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Out In The Open</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
	<!-- Play Areas -->
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="playAreasHeading">
						<h3 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#playAreas" aria-expanded="false" aria-controls="playAreas">
								Play Areas
					        </a>
						</h3>
					</div>
					<div id="playAreas" class="panel-collapse collapse" role="tabpanel" aria-labelledby="playAreas">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-3">
									<h5>Clean?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_PLAY_AREA.clean == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_PLAY_AREA.clean == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-3">
									<h5>Location?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_PLAY_AREA.inside == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Inside</li>
										<li><span class="${BUSINESS_PLAY_AREA.outside == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Outside</li>
									</ul>
								</div>
								<div class="col-sm-3">
									<h5>Gated?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_PLAY_AREA.gated == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_PLAY_AREA.gated == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
								<div class="col-sm-3">
									<h5>Fun?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_PLAY_AREA.fun == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_PLAY_AREA.fun == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
	<!-- Restaurants & Menus -->
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="restaurantMenuHeading">
						<h3 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#restaurantMenu" aria-expanded="false" aria-controls="restaurantMenu">
								Restaurants & Menus
					        </a>
						</h3>
					</div>
					<div id="restaurantMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="restaurantMenu">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-6">
									<h5>Seating Available?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTAURANT_MENU.highChair == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> High Chairs</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.booster == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Boosters</li>
									</ul>
								</div>
								<div class="col-sm-6">
									<h5>Activities Available?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTAURANT_MENU.activities == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.activities == false ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No</li>
									</ul>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<h5>Kids Menu?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTAURANT_MENU.healthy == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Healthy Options Available</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.allergyFriendly == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Allergy Friendly</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.unhealthy == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> It's All Sugar</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.noKidsMenu == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> No Kids Menu</li>
									</ul>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<h5>Full Menu Options?</h5>
									<ul class="list-inline list-unstyled">
										<li><span class="${BUSINESS_RESTAURANT_MENU.manyOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Yes, so many!</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.someOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> Some. You can make it work.</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.fewOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> There are few options.</li>
										<li><span class="${BUSINESS_RESTAURANT_MENU.noOpts == true ?  'glyphicon glyphicon-check' : 'glyphicon glyphicon-unchecked'}" aria-hidden="true"></span> None. It's all Escargots à la Bourguignonne</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- Section Heading - MORE DETAILS -->
	<div class="row">
		<div class="col-sm-12">
			<h2>More Details</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
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