<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.kidfriendlystl.State" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/zipcodeUS.js" type="text/javascript"></script>
	<script src="js/phoneUS.js" type="text/javascript"></script>
	<script src="js/validate-form.js" type="text/javascript"></script>
	<title>
		<c:choose>
			<c:when test="${empty THE_BUSINESS.id}">
				Add New Listing
			</c:when>
			<c:otherwise>
				Update ${THE_BUSINESS.name}
			</c:otherwise>
		</c:choose>
	</title>
</head>
<body>
<div class="container">
<!-- HEADING & SUB-HEADING -->
	<h1>Kid Friendly STL</h1>
	<h1><small>
		<c:choose>
			<c:when test="${empty THE_BUSINESS.id}">
				Add New Listing
			</c:when>
			<c:otherwise>
				Update ${THE_BUSINESS.name}
			</c:otherwise>
		</c:choose>
	</small></h1>
	<br />
<!-- START FORM -->	
	<form id="kidFriendlyListing" action="FriendlyControllerServlet" method="POST">
<!-- Establish NEW or EXISTING Listing -->
		<c:choose>
			<c:when test="${empty THE_BUSINESS.id}">
				<input type="hidden" name="command" value="ADD" />
			</c:when>
			<c:otherwise>
				<input type="hidden" name="command" value="UPDATE" />
				<input type="hidden" name="businessID" value="${THE_BUSINESS.id}" />
			</c:otherwise>
		</c:choose>
<!-- CONTACT INFORMATION -->
		<div class="row">
			<div class="col-sm-12">
				<h2>Let's Get The Basics</h2>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
			<div class="col-sm-12">
				<label for="business">Business Name*</label><br>
				<input required type="text" class="form-control" name="businessName" id="businessName" placeholder="Name" value="${empty THE_BUSINESS.name ? '': THE_BUSINESS.name}">
			</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
			<div class="col-sm-12">
				<label for="businessAddress">Address*</label><br>
				<input required type="text" class="form-control" name="businessAddress" id="businessAddress" placeholder="Address" value="${empty THE_BUSINESS.address ? '': THE_BUSINESS.address}">
			</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
			<div class="form-group">
				<label for="businessCity">City*</label>
				<input required type="text" class="form-control" name="businessCity" id="businessCity" placeholder="City" value="${empty THE_BUSINESS.city ? 'Saint Louis': THE_BUSINESS.city}">
			</div>
			</div>
			<div class="col-sm-4">
			<div class="form-group">
				<label for="businessState">State*</label>
				<select class="form-control" name="businessState" id="businessState">
					<c:forEach items="<%=State.values()%>" var="state">
						<option value="${state.abbreviation}" ${THE_BUSINESS.state == state.abbreviation ? 'selected' : ''}>${state.name}</option>
					</c:forEach>
				</select>
			</div>
			</div>
			<div class="col-sm-4">
			<div class="form-group">
				<label for="businessZip">Zip</label>
				<input type="text" class="form-control" name="businessZip" id="businessZip" placeholder="Zip (5-digit)" value="${empty THE_BUSINESS.zip ? '': THE_BUSINESS.zip}">
			</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
			<div class="form-group">
				<label for="businessPhone">Phone</label><br>
				<input type="tel" class="form-control" name="businessPhone" id="businessPhone" placeholder="Phone (10-digit)"  value="${empty THE_BUSINESS.phone ? '': THE_BUSINESS.phone}">
			</div>
			</div>
			<div class="col-sm-6">
			<div class="form-group">
				<label for="businessWebsite">Website</label><br>
				<input type="url" class="form-control" name="businessWebsite" id="businessWebsite" placeholder="Website"  value="${empty THE_BUSINESS.website ? '': THE_BUSINESS.website}">
			</div>
			</div>
		</div>
		<br />
		<div class="row">
<!-- OVERALL RATING -->
			<div class="col-sm-2">
				<h5>Overall Rating</h5>
				<div class="radio form-group">
					<label class="radio" for="businessRating5">
						<input type="radio" name="businessRating" id="businessRating5" value=5 ${THE_BUSINESS.rating == 5 ? 'checked' : '' }>
						<c:forEach begin="1" end="5">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="0">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</label>
					<label class="radio" for="businessRating4">
						<input type="radio" name="businessRating" id="businessRating4" value=4 ${THE_BUSINESS.rating == 4 ? 'checked' : '' }>
						<c:forEach begin="1" end="4">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="1">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</label>
					<label class="radio" for="businessRating3">
						<input type="radio" name="businessRating" id="businessRating3" value=3 ${empty THE_BUSINESS.rating || THE_BUSINESSL.rating == 3 ? 'checked' : '' }>
						<c:forEach begin="1" end="3">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="2">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</label>
					<label class="radio" for="businessRating2">
						<input type="radio" name="businessRating" id="businessRating2" value=2 ${THE_BUSINESS.rating == 2 ? 'checked' : '' }>
						<c:forEach begin="1" end="2">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="3">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</label>
					<label class="radio" for="businessRating1">
						<input type="radio" name="businessRating" id="businessRating1" value=1 ${THE_BUSINESS.rating == 1 ? 'checked' : '' }>
						<c:forEach begin="1" end="1">
			   				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</c:forEach>
						<c:forEach begin="1" end="4">
			   				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
						</c:forEach>
					</label>
				</div>
			</div>
<!-- CATEGORY -->
			<div class="col-sm-3">	
				<h5>Categories*</h5>
				<div class="checkbox form-group">
					<label class="checkbox" for="activeLife">
						<input type="checkbox" name="category" id="activeLife" value="activeLife" ${BUSINESS_CATEGORY.activeLife == true ? 'checked' : '' }> Active Life
					</label>
					<label class="checkbox" for="artsEntertainment">
						<input type="checkbox" name="category" id="artsEntertainment" value="artsEntertainment" ${BUSINESS_CATEGORY.artsEntertainment == true ? 'checked' : '' }> Arts & Entertainment
					</label>
					<label class="checkbox" for="education">
						<input type="checkbox" name="category" id="education" value="education" ${BUSINESS_CATEGORY.education == true ? 'checked' : '' }> Education
					</label>
					<label class="checkbox" for="foodRestaurant">
						<input type="checkbox" name="category" id="foodRestaurant" value="foodRestaurant" ${BUSINESS_CATEGORY.foodRestaurant == true ? 'checked' : '' }> Food & Restaurant
					</label>
					<label class="checkbox" for="healthMedical">
						<input type="checkbox" name="category" id="healthMedical" value="healthMedical" ${BUSINESS_CATEGORY.healthMedical == true ? 'checked' : '' }> Health & Medical
					</label>
					<label class="checkbox" for="hotelTravel">
						<input type="checkbox" name="category" id="hotelTravel" value="hotelTravel" ${BUSINESS_CATEGORY.hotelTravel == true ? 'checked' : '' }> Hotels & Travel
					</label>
					<label class="checkbox" for="publicServiceGovernment">
						<input type="checkbox" name="category" id="publicServiceGovernment" value="publicServiceGovernment" ${BUSINESS_CATEGORY.publicServiceGovernment == true ? 'checked' : ' ' }> Public Services
					</label>
					<label class="checkbox" for="religious">
						<input type="checkbox" name="category" id="religious" value="religious" ${BUSINESS_CATEGORY.religious == true ? 'checked' : '' }> Religious
					</label>
					<label class="checkbox" for="shopping">
						<input type="checkbox" name="category" id="shopping" value="shopping" ${BUSINESS_CATEGORY.shopping == true ? 'checked' : '' }> Shopping
					</label>
				</div>
			</div>
<!-- AGE RANGES -->
			<div class="col-sm-2">
				<h5>Age Ranges*</h5>
				<div class="checkbox form-group">
					<label class="checkbox" for="baby">
						<input type="checkbox" name="ageRange" id="baby" value="baby" ${BUSINESS_AGE_RANGE.baby == true ? 'checked' : '' }> Baby
					</label>
					<label class="checkbox" for="toddler">
						<input type="checkbox" name="ageRange" id="toddler" value="toddler" ${BUSINESS_AGE_RANGE.toddler == true ? 'checked' : '' }> Toddler
					</label>
					<label class="checkbox" for="preschooler">
						<input type="checkbox" name="ageRange" id="preschooler" value="preschooler" ${BUSINESS_AGE_RANGE.preschooler == true ? 'checked' : '' }> Preschooler
					</label>
					<label class="checkbox" for="gradeSchooler">
						<input type="checkbox" name="ageRange" id="gradeSchooler" value="gradeSchooler" ${BUSINESS_AGE_RANGE.gradeSchooler == true ? 'checked' : '' }> Grade Schooler
					</label>
					<label class="checkbox" for="teen">
						<input type="checkbox" name="ageRange" id="teen" value="teen" ${BUSINESS_AGE_RANGE.teen == true ? 'checked' : '' }> Teen
					</label>
				</div>
			</div>
<!-- KID FRIENDLY DETAILS - Best Times -->
			<div class="col-sm-2">
				<h5>Best Times*</h5>
				<div class="checkbox form-group">
					<label class="checkbox" for="morning">
						<input type="checkbox" name="bestTimes" id="morning" value="morning" ${BUSINESS_KID_FRIENDLY_DETAIL.morning == true ? 'checked' : '' }> Morning
					</label>
					<label class="checkbox" for="afternoon">
						<input type="checkbox" name="bestTimes" id="afternoon" value="afternoon" ${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true ? 'checked' : '' }> Afternoon
					</label>
					<label class="checkbox" for="evening">
						<input type="checkbox" name="bestTimes" id="evening" value="evening" ${BUSINESS_KID_FRIENDLY_DETAIL.evening == true ? 'checked' : '' }> Evening
					</label>
				</div>
			</div>
<!-- KID FRIENDLY DETAILS - Details -->
			<div class="col-sm-3">	
				<h5>Kid Friendly Details</h5>
				<div class="radio form-group">
					<p>Lots of Families?*</p>
					<label class="radio-inline" for="multipleFamiliesTrue">
						<input type="radio" name="multipleFamilies" id="multipleFamiliesTrue" value=1 ${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true ? 'checked' : '' }> Yes!
					</label>
					<label class="radio-inline" for="multipleFamiliesFalse">
						<input type="radio" name="multipleFamilies" id="multipleFamiliesFalse" value=0  ${empty BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies || BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == false ? 'checked' : '' }> No
					</label>
				</div>
				<br />
				<div class="radio form-group">
					<p>Kid's Discount Offered?*</p>
					<label class="radio-inline" for="kidsFreeDiscountTrue">
						<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountTrue" value=1 ${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true ? 'checked' : '' }> Yes!
					</label>
					<label class="radio-inline" for="kidsFreeDiscountFalse">
						<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountFalse" value=0   ${empty BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount || BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == false ? 'checked' : '' }> No
					</label>
				</div>
			</div>
		</div>
		<br />
<!-- SPECIFICS -->
		<div class="row">
			<div class="col-sm-12">
				<h2>Let's Get Specific!</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
<!-- SPECIFICS - Restrooms -->
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="restroomsHeading">
				      <h3 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#restrooms" aria-expanded="true" aria-controls="restrooms">
				          Restrooms
				        </a>
				      </h3>
				    </div>
				    <div id="restrooms" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="restrooms">
				      <div class="panel-body">
				      	<div class="row">
				      		<div class="col-sm-4">
								<div class="radio form-group">
									<h5>Clean?</h5>
									<label class="radio-inline" for="restroomClean">
										<input type="radio" name="restroomClean" id="restroomCleanTrue" value=1 ${BUSINESS_RESTROOM.clean == true ? 'checked' : '' }> Yes!
									</label>
									<label class="radio-inline" for="restroomClean">
										<input type="radio" name="restroomClean" id="restroomCleanFalse" value=0  ${empty BUSINESS_RESTROOM.clean || BUSINESS_RESTROOM.clean == false ? 'checked' : '' }> No
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-4">
								<div class="radio form-group">
									<h5>Toddler Safety Seat?</h5>
									<label class="radio-inline" for="toddlerSeat">
										<input type="radio" name="toddlerSeat" id="toddlerSeatTrue" value=1 ${BUSINESS_RESTROOM.toddlerSeat == true ? 'checked' : '' }> Yes!
									</label>
									<label class="radio-inline" for="toddlerSeat">
										<input type="radio" name="toddlerSeat" id="toddlerSeatFalse" value=0  ${empty BUSINESS_RESTROOM.toddlerSeat || BUSINESS_RESTROOM.toddlerSeat == false ? 'checked' : '' }> No
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-4">
								<div class="radio form-group">
									<h5>Obnoxious Hand Dryer?</h5>
									<label class="radio-inline" for="handDryer">
										<input type="radio" name="handDryer" id="handDryerTrue" value=1 ${BUSINESS_RESTROOM.handDryer == true ? 'checked' : '' }> Yes
									</label>
									<label class="radio-inline" for="handDryer">
										<input type="radio" name="handDryer" id="handDryerFalse" value=0  ${empty BUSINESS_RESTROOM.handDryer || BUSINESS_RESTROOM.handDryer == false ? 'checked' : '' }> No!
									</label>
								</div>
				      		</div>
				      	</div>
				      	<div class="row">
				      		<div class="col-sm-12">
								<div class="checkbox form-group">
									<h5>What's the changing table situation?</h5>
									<label class="checkbox-inline" for="womensRoom">
										<input type="checkbox" name="changingTable" id="womensRoom" value="womensRoom" ${BUSINESS_RESTROOM.womensRoom == true ? 'checked' : '' }> Women's Room
									</label>
									<label class="checkbox-inline" for="mensRoom">
										<input type="checkbox" name="changingTable" id="mensRoom" value="mensRoom" ${BUSINESS_RESTROOM.mensRoom == true ? 'checked' : '' }> Men's Room
									</label>
									<label class="checkbox-inline" for="familyRoom">
										<input type="checkbox" name="changingTable" id="familyRoom" value="familyRoom" ${BUSINESS_RESTROOM.familyRoom == true ? 'checked' : '' }> Family Room
									</label>
									<label class="checkbox-inline" for="noChangingTable">
										<input type="checkbox" name="noChangingTable" id="noChangingTable" value="noChangingTable" ${BUSINESS_RESTROOM.noChangingTable == true ? 'checked' : '' }> NONE!
									</label>
								</div>
				      		</div>
				      	</div>
				      </div>
				    </div>
				  </div>
<!-- SPECIFICS - Breastfeeding -->
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
								<div class="radio form-group">
									<h5>Clean?</h5>
									<label class="radio-inline" for="breastfeedingClean">
										<input type="radio" name="breastfeedingClean" id="breastfeedingCleanTrue" value=1 ${BUSINESS_BREASTFEEDING.clean == true ? 'checked' : '' }> Yes!
									</label>
									<label class="radio-inline" for="breastfeedingClean">
										<input type="radio" name="breastfeedingClean" id="breastfeedingCleanFalse" value=0  ${empty BUSINESS_BREASTFEEDING.clean || BUSINESS_BREASTFEEDING.clean == false ? 'checked' : '' }> No
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-4">
								<div class="radio form-group">
									<h5>Are you comfortable breastfeeding here?</h5>
									<label class="radio-inline" for="comfortable">
										<input type="radio" name="comfortable" id="comfortableTrue" value=1 ${BUSINESS_BREASTFEEDING.comfortable == true ? 'checked' : '' }> Yes!
									</label>
									<label class="radio-inline" for="comfortable">
										<input type="radio" name="comfortable" id="comfortableFalse" value=0  ${empty BUSINESS_BREASTFEEDING.comfortable || BUSINESS_BREASTFEEDING.comfortable == false ? 'checked' : '' }> No
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-4">
								<div class="radio form-group">
									<h5>Bottle Warmers?</h5>
									<label class="radio-inline" for="bottleWarmer">
										<input type="radio" name="bottleWarmer" id="bottleWarmerTrue" value=1 ${BUSINESS_BREASTFEEDING.bottleWarmer == true ? 'checked' : '' }> Yes
									</label>
									<label class="radio-inline" for="bottleWarmer">
										<input type="radio" name="bottleWarmer" id="bottleWarmerFalse" value=0  ${empty BUSINESS_BREASTFEEDING.bottleWarmer || BUSINESS_BREASTFEEDING.bottleWarmer == false ? 'checked' : '' }> No!
									</label>
								</div>
				      		</div>
				      	</div>
				      	<div class="row">
				      		<div class="col-sm-12">
								<div class="checkbox form-group">
									<h5>Where are you popping your boobs?</h5>
									<label class="checkbox-inline" for="lactationRoom">
										<input type="checkbox" name="poppingBoobs" id="lactationRoom" value="lactationRoom" ${BUSINESS_BREASTFEEDING.lactationRoom == true ? 'checked' : '' }> Lactation Room
									</label>
									<label class="checkbox-inline" for="quietArea">
										<input type="checkbox" name="poppingBoobs" id="quietArea" value="quietArea" ${BUSINESS_BREASTFEEDING.quietArea == true ? 'checked' : '' }> Private, Quiet Area
									</label>
									<label class="checkbox-inline" for="grossOpts">
										<input type="checkbox" name="poppingBoobs" id="grossOpts" value="grossOpts" ${BUSINESS_BREASTFEEDING.grossOpts == true ? 'checked' : '' }> Dirty Bathroom Stall
									</label>
									<label class="checkbox-inline" for="nonSpecificOpts">
										<input type="checkbox" name="poppingBoobs" id="nonSpecificOpts" value="nonSpecificOpts" ${BUSINESS_BREASTFEEDING.nonSpecificOpts == true ? 'checked' : '' }> Out In The Open
									</label>
								</div>
				      		</div>
				      	</div>
				      </div>
				    </div>
				  </div>
<!-- SPECIFICS - Play Areas -->
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
								<div class="radio form-group">
									<h5>Clean?</h5>
									<label class="radio-inline" for="playAreaClean">
										<input type="radio" name="playAreaClean" id="playAreaCleanTrue" value=1 ${BUSINESS_PLAY_AREA.clean == true ? 'checked' : '' }> Yes, mostly.
									</label>
									<label class="radio-inline" for="playAreaClean">
										<input type="radio" name="playAreaClean" id="playAreaCleanFalse" value=0  ${empty BUSINESS_PLAY_AREA.clean || BUSINESS_PLAY_AREA.clean == false ? 'checked' : '' }> Nope.
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-3">
								<div class="checkbox form-group">
									<h5>Location</h5>
									<label class="checkbox-inline" for="inside">
										<input type="checkbox" name="location" id="inside" value="inside" ${BUSINESS_PLAY_AREA.inside == true ? 'checked' : '' }> It's Indoors
									</label>
									<label class="checkbox-inline" for="outside">
										<input type="checkbox" name="location" id="outside" value="outside" ${BUSINESS_PLAY_AREA.outside == true ? 'checked' : '' }> It's Outside
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-3">
								<div class="radio form-group">
									<h5>Clean?</h5>
									<label class="radio-inline" for="gated">
										<input type="radio" name="gated" id="gatedTrue" value=1 ${BUSINESS_PLAY_AREA.gated == true ? 'checked' : '' }> Yes.
									</label>
									<label class="radio-inline" for="gated">
										<input type="radio" name="gated" id="gatedFalse" value=0  ${empty BUSINESS_PLAY_AREA.gated || BUSINESS_PLAY_AREA.gated == false ? 'checked' : '' }> Nope.
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-3">
								<div class="radio form-group">
									<h5>Fun?</h5>
									<label class="radio-inline" for="fun">
										<input type="radio" name="fun" id="funTrue" value=1 ${BUSINESS_PLAY_AREA.fun == true ? 'checked' : '' }> Yes, mostly.
									</label>
									<label class="radio-inline" for="fun">
										<input type="radio" name="fun" id="funFalse" value=0  ${empty BUSINESS_PLAY_AREA.fun || BUSINESS_PLAY_AREA.fun == false ? 'checked' : '' }> Not really.
									</label>
								</div>
				      		</div>
				      	</div>
				      </div>
				    </div>
				  </div>
<!-- SPECIFICS - Restaurants & Menus -->
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
								<div class="checkbox form-group">
									<h5>Seating Options</h5>
									<label class="checkbox-inline" for="highChair">
										<input type="checkbox" name="seating" id="highChair" value="highChair" ${BUSINESS_RESTAURANT_MENU.highChair == true ? 'checked' : '' }> High Chairs
									</label>
									<label class="checkbox-inline" for="booster">
										<input type="checkbox" name="seating" id="booster" value="booster" ${BUSINESS_RESTAURANT_MENU.booster == true ? 'checked' : '' }> Booster Seats
									</label>
								</div>
				      		</div>
				      		<div class="col-sm-6">
								<div class="radio form-group">
									<h5>Activities</h5>
									<label class="radio-inline" for="activities">
										<input type="radio" name="activities" id="activitiesTrue" value=1 ${BUSINESS_RESTAURANT_MENU.activities == true ? 'checked' : '' }> Crayons (or the like)
									</label>
									<label class="radio-inline" for="activities">
										<input type="radio" name="activities" id="activitiesFalse" value=0  ${empty BUSINESS_RESTAURANT_MENU.activities || BUSINESS_RESTAURANT_MENU.activities == false ? 'checked' : '' }> Not provided
									</label>
								</div>
				      		</div>
				      	</div>
				      	<div class="row">
				      		<div class="col-sm-12">
								<div class="checkbox form-group">
									<h5>Kids Menu</h5>
									<label class="checkbox-inline" for="healthy">
										<input type="checkbox" name="kidsMenu" id="healthy" value="healthy" ${BUSINESS_RESTAURANT_MENU.healthy == true ? 'checked' : '' }> Healthy Options Available
									</label>
									<label class="checkbox-inline" for="allergyFriendly">
										<input type="checkbox" name="kidsMenu" id="allergyFriendly" value="allergyFriendly" ${BUSINESS_RESTAURANT_MENU.allergyFriendly == true ? 'checked' : '' }> Allergy Friendly
									</label>
									<label class="checkbox-inline" for="unhealthy">
										<input type="checkbox" name="kidsMenu" id="unhealthy" value="unhealthy" ${BUSINESS_RESTAURANT_MENU.unhealthy == true ? 'checked' : '' }> It's All Sugar
									</label>
									<label class="checkbox-inline" for="noKidsMenu">
										<input type="checkbox" name="kidsMenu" id="noKidsMenu" value="noKidsMenu" ${BUSINESS_RESTAURANT_MENU.noKidsMenu == true ? 'checked' : '' }> No Kids Menu
									</label>
								</div>
				      		</div>
				      	</div>
				      	<div class="row">
				      		<div class="col-sm-12">
								<div class="checkbox form-group">
									<h5>Full Menu Options</h5>
									<label class="checkbox-inline" for="manyOpts">
										<input type="checkbox" name="fullMenu" id="manyOpts" value="manyOpts" ${BUSINESS_RESTAURANT_MENU.manyOpts == true ? 'checked' : '' }> Yes, so many!
									</label>
									<label class="checkbox-inline" for="someOpts">
										<input type="checkbox" name="fullMenu" id="someOpts" value="someOpts" ${BUSINESS_RESTAURANT_MENU.someOpts == true ? 'checked' : '' }> Some. You can make it work.
									</label>
									<label class="checkbox-inline" for="fewOpts">
										<input type="checkbox" name="fullMenu" id="fewOpts" value="fewOpts" ${BUSINESS_RESTAURANT_MENU.fewOpts == true ? 'checked' : '' }> There are few options.
									</label>
									<label class="checkbox-inline" for="noOpts">
										<input type="checkbox" name="fullMenu" id="noOpts" value="noOpts" ${BUSINESS_RESTAURANT_MENU.noOpts == true ? 'checked' : '' }> None. It's all Escargots à la Bourguignonne
									</label>
								</div>
				      		</div>
				      	</div>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
		<br />
<!-- KID FRIENDLY DETAILS -->
		<div class="row">
			<div class="col-sm-12">
				<h2>More To Share?</h2>
				<p><small>Limit 255 characters</small></p>
				<div class="form-group">
					<label for="kidsFreeDiscountDetail"></label>
					<textarea class="form-control" rows="3" name="kidsFreeDiscountDetail" id="kidsFreeDiscountDetail" placeholder="Business Details">${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}</textarea>
				</div>
			</div>
		</div>
		<br />
<!-- BUTTONS -->
		<c:if test="${not empty THE_BUSINESS.id}">
			<c:url var="cancelLink" value="FriendlyControllerServlet">
				<c:param name="command" value="VIEW" />
				<c:param name="businessID" value="${THE_BUSINESS.id}" />
			</c:url>
		</c:if>
			<input class="btn btn-default" type="submit" value="${empty THE_BUSINESS.id ? 'Submit': 'Update'}">
			<a class="btn btn-danger" href="${empty cancelLink ? 'FriendlyControllerServlet' : cancelLink}" role="button">Cancel</a>
		<br /><br />
	</form>
	<br />	  
</div>
</body>
</html>