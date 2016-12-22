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

		<h1>Kid Friendly STL  
		<small>
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
		
		<form action="FriendlyControllerServlet" method="POST">
			<c:choose>
				<c:when test="${empty THE_BUSINESS.id}">
					<input type="hidden" name="command" value="ADD" />
				</c:when>
				<c:otherwise>
					<input type="hidden" name="command" value="UPDATE" />
					<input type="hidden" name="businessID" value="${THE_BUSINESS.id}" />
				</c:otherwise>
			</c:choose>
		
		
		
				<!-- Contact Information -->
				<div class="row">
					<div class="form-group">
					<div class="col-md-12">
						<label for="business">Business Name</label><br>
						<input type="text" class="form-control" name="businessName" id="businessName" placeholder="Name" value="${empty THE_BUSINESS.name ? '': THE_BUSINESS.name}">
					</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="form-group">
					<div class="col-md-12">
						<label for="address">Address</label><br>
						<input type="text" class="form-control" name="businessAddress" id="businessAddress" placeholder="Address" value="${empty THE_BUSINESS.address ? '': THE_BUSINESS.address}">
					</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
					<div class="col-md-4">
						<input type="text" class="form-control" name="businessCity" id="businessCity" placeholder="City" value="${empty THE_BUSINESS.city ? '': THE_BUSINESS.city}">
					</div>
					<div class="col-md-4">
						<input type="text" class="form-control" name="businessState" id="businessState" placeholder="State"  value="${empty THE_BUSINESS.state ? '': THE_BUSINESS.state}">
					</div>
					<div class="col-md-4">
						<input type="text" class="form-control" name="businessZip" id="businessZip" placeholder="Zip (5-digit)"  value="${empty THE_BUSINESS.zip ? '': THE_BUSINESS.zip}">
					</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="form-group">
					<div class="col-md-6">
						<label for="businessPhone">Phone</label><br>
						<input type="tel" class="form-control" name="businessPhone" id="businessPhone" placeholder="Phone (10-digit)"  value="${empty THE_BUSINESS.phone ? '': THE_BUSINESS.phone}">
					</div>
					<div class="col-md-6">
						<label for="businessWebsite">Website</label><br>
						<input type="text" class="form-control" name="businessWebsite" id="businessWebsite" placeholder="Website"  value="${empty THE_BUSINESS.website ? '': THE_BUSINESS.website}">
					</div>
					</div>
				</div>
				<br>


	<br>
	<div class="row">
	
		<!-- Category -->
		<div class="col-md-4">	
				<label for="category">Categories</label>
				<p><small>Please select at least one category:</small></p>
			<div class="checkbox">
				<label class="checkbox">
					<input type="checkbox" name="category" id="activeLife" value="activeLife" ${BUSINESS_CATEGORY.activeLife == true ? 'checked' : '' }> Active Life
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="artsEntertainment" value="artsEntertainment" ${BUSINESS_CATEGORY.artsEntertainment == true ? 'checked' : '' }> Arts & Entertainment
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="education" value="education" ${BUSINESS_CATEGORY.education == true ? 'checked' : '' }> Education
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="foodRestaurant" value="foodRestaurant" ${BUSINESS_CATEGORY.foodRestaurant == true ? 'checked' : '' }> Food & Restaurant
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="healthMedical" value="healthMedical" ${BUSINESS_CATEGORY.healthMedical == true ? 'checked' : '' }> Health & Medical
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="hotelTravel" value="hotelTravel" ${BUSINESS_CATEGORY.hotelTravel == true ? 'checked' : '' }> Hotels & Travel
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="publicServiceGovernment" value="publicServiceGovernment" ${BUSINESS_CATEGORY.publicServiceGovernment == true ? 'checked' : ' ' }> Public Services
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="religious" value="religious" ${BUSINESS_CATEGORY.religious == true ? 'checked' : '' }> Religious
				</label>
				<label class="checkbox">
					<input type="checkbox" name="category" id="shopping" value="shopping" ${BUSINESS_CATEGORY.shopping == true ? 'checked' : '' }> Shopping
				</label>
			</div>
		</div>
		
		<!-- Age Ranges -->
		<div class="col-md-4">
				<label for="ageRange">Age Ranges</label>
				<p><small>Please select at least one age group:</small></p>
			<div class="checkbox">
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="allAges" value="allAges" ${BUSINESS_AGE_RANGE.allAges == true ? 'checked' : '' }> All Ages
				</label>
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="baby" value="baby" ${BUSINESS_AGE_RANGE.baby == true ? 'checked' : '' }> Baby
				</label>
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="toddler" value="toddler" ${BUSINESS_AGE_RANGE.toddler == true ? 'checked' : '' }> Toddler
				</label>
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="preschooler" value="preschooler" ${BUSINESS_AGE_RANGE.preschooler == true ? 'checked' : '' }> Preschooler
				</label>
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="gradeSchooler" value="gradeSchooler" ${BUSINESS_AGE_RANGE.gradeSchooler == true ? 'checked' : '' }> Grade Schooler
				</label>
				<label class="checkbox">
					<input type="checkbox" name="ageRange" id="teen" value="teen" ${BUSINESS_AGE_RANGE.teen == true ? 'checked' : '' }> Teen
				</label>
			</div>
		</div>

		<!-- KID FRIENDLY DETAILS - Best Times -->
		<div class="col-md-4">
				<label for="bestTimes">Best Times</label>
				<p><small>Please select at least one time:</small></p>
			<div class="checkbox">
				<label class="checkbox">
					<input type="checkbox" name="bestTimes" id="allDay" value="allDay" ${BUSINESS_KID_FRIENDLY_DETAIL.allDay == true ? 'checked' : '' }> All Day
				</label>
				<label class="checkbox">
					<input type="checkbox" name="bestTimes" id="morning" value="morning" ${BUSINESS_KID_FRIENDLY_DETAIL.morning == true ? 'checked' : '' }> Morning
				</label>
				<label class="checkbox">
					<input type="checkbox" name="bestTimes" id="afternoon" value="afternoon" ${BUSINESS_KID_FRIENDLY_DETAIL.afternoon == true ? 'checked' : '' }> Afternoon
				</label>
				<label class="checkbox">
					<input type="checkbox" name="bestTimes" id="evening" value="evening" ${BUSINESS_KID_FRIENDLY_DETAIL.evening == true ? 'checked' : '' }> Evening
				</label>
			</div>
		</div>
	</div>


	<br>
	<div class="row">
		<!-- KID FRIENDLY DETAILS -->
		<div class="col-md-12">	
				<label for="kidFriendlyDetails">Kid Friendly Details</label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="radio">
				Lots of Families?  
				<label class="radio-inline">
					<input type="radio" name="multipleFamilies" id="multipleFamiliesTrue" value=1 ${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true ? 'checked' : '' }>
					Yes!
				</label>
				<label class="radio-inline">
					<input type="radio" name="multipleFamilies" id="multipleFamiliesFalse" value=0  ${empty BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies || BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == false ? 'checked' : '' }>
					No
				</label>
			</div>
		</div>
		<div class="col-md-6">
			<div class="radio">
				Kid's Free or Kid's Discount Offered?  
				<label class="radio-inline">
					<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountTrue" value=1 ${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == true ? 'checked' : '' }>
					Yes!
				</label>
				<label class="radio-inline">
					<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountFalse" value=0   ${empty BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount || BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscount == false ? 'checked' : '' }>
					No
				</label>
			</div>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-12">
			<p><small>Limit 255 characters</small></p>
			<textarea class="form-control" rows="3" name="kidsFreeDiscountDetail" id="kidsFreeDiscountDetail" placeholder="Kid's Discount Details">${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}</textarea>
		</div>
	</div>
	<br>


		<!-- Buttons -->
		<c:if test="${not empty THE_BUSINESS.id}">
			<c:url var="cancelLink" value="FriendlyControllerServlet">
				<c:param name="command" value="VIEW" />
				<c:param name="businessID" value="${THE_BUSINESS.id}" />
			</c:url>
		</c:if>
			<input class="btn btn-default" type="submit" value="${empty THE_BUSINESS.id ? 'Submit': 'Update'}">
			<a class="btn btn-danger" href="${empty cancelLink ? 'FriendlyControllerServlet' : cancelLink}" role="button">Cancel</a>
			
			<br><br>

		</form>	  
		</div>

</body>
</html>