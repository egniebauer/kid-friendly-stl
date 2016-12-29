<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/zipcodeUS.js" type="text/javascript"></script>
	<script src="js/statesUS.js" type="text/javascript"></script>
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
				<label for="businessAddress">Address</label><br>
				<input type="text" class="form-control" name="businessAddress" id="businessAddress" placeholder="Address" value="${empty THE_BUSINESS.address ? '': THE_BUSINESS.address}">
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
					<option value="AL" ${THE_BUSINESS.state == "AL" ? 'selected' : ''}>Alabama</option>
					<option value="AK" ${THE_BUSINESS.state == "AK" ? 'selected' : ''}>Alaska</option>
					<option value="AZ" ${THE_BUSINESS.state == "AZ" ? 'selected' : ''}>Arizona</option>
					<option value="AR" ${THE_BUSINESS.state == "AR" ? 'selected' : ''}>Arkansas</option>
					<option value="CA" ${THE_BUSINESS.state == "CA" ? 'selected' : ''}>California</option>
					<option value="CO" ${THE_BUSINESS.state == "CO" ? 'selected' : ''}>Colorado</option>
					<option value="CT" ${THE_BUSINESS.state == "CT" ? 'selected' : ''}>Connecticut</option>
					<option value="DE" ${THE_BUSINESS.state == "DE" ? 'selected' : ''}>Delaware</option>
					<option value="DC" ${THE_BUSINESS.state == "DC" ? 'selected' : ''}>District Of Columbia</option>
					<option value="FL" ${THE_BUSINESS.state == "FL" ? 'selected' : ''}>Florida</option>
					<option value="GA" ${THE_BUSINESS.state == "GA" ? 'selected' : ''}>Georgia</option>
					<option value="HI" ${THE_BUSINESS.state == "HI" ? 'selected' : ''}>Hawaii</option>
					<option value="ID" ${THE_BUSINESS.state == "ID" ? 'selected' : ''}>Idaho</option>
					<option value="IL" ${THE_BUSINESS.state == "IL" ? 'selected' : ''}>Illinois</option>
					<option value="IN" ${THE_BUSINESS.state == "IN" ? 'selected' : ''}>Indiana</option>
					<option value="IA" ${THE_BUSINESS.state == "IA" ? 'selected' : ''}>Iowa</option>
					<option value="KS" ${THE_BUSINESS.state == "KS" ? 'selected' : ''}>Kansas</option>
					<option value="KY" ${THE_BUSINESS.state == "KY" ? 'selected' : ''}>Kentucky</option>
					<option value="LA" ${THE_BUSINESS.state == "LA" ? 'selected' : ''}>Louisiana</option>
					<option value="ME" ${THE_BUSINESS.state == "ME" ? 'selected' : ''}>Maine</option>
					<option value="MD" ${THE_BUSINESS.state == "MD" ? 'selected' : ''}>Maryland</option>
					<option value="MA" ${THE_BUSINESS.state == "MA" ? 'selected' : ''}>Massachusetts</option>
					<option value="MI" ${THE_BUSINESS.state == "MI" ? 'selected' : ''}>Michigan</option>
					<option value="MN" ${THE_BUSINESS.state == "MN" ? 'selected' : ''}>Minnesota</option>
					<option value="MS" ${THE_BUSINESS.state == "MS" ? 'selected' : ''}>Mississippi</option>
					<option value="MO" ${ empty THE_BUSINESS.state or THE_BUSINESS.state == "MO" ? 'selected' : ''}>Missouri</option>
					<option value="MT" ${THE_BUSINESS.state == "MT" ? 'selected' : ''}>Montana</option>
					<option value="NE" ${THE_BUSINESS.state == "NE" ? 'selected' : ''}>Nebraska</option>
					<option value="NV" ${THE_BUSINESS.state == "NV" ? 'selected' : ''}>Nevada</option>
					<option value="NH" ${THE_BUSINESS.state == "NH" ? 'selected' : ''}>New Hampshire</option>
					<option value="NJ" ${THE_BUSINESS.state == "NJ" ? 'selected' : ''}>New Jersey</option>
					<option value="NM" ${THE_BUSINESS.state == "NM" ? 'selected' : ''}>New Mexico</option>
					<option value="NY" ${THE_BUSINESS.state == "NY" ? 'selected' : ''}>New York</option>
					<option value="NC" ${THE_BUSINESS.state == "NC" ? 'selected' : ''}>North Carolina</option>
					<option value="ND" ${THE_BUSINESS.state == "ND" ? 'selected' : ''}>North Dakota</option>
					<option value="OH" ${THE_BUSINESS.state == "OH" ? 'selected' : ''}>Ohio</option>
					<option value="OK" ${THE_BUSINESS.state == "OK" ? 'selected' : ''}>Oklahoma</option>
					<option value="OR" ${THE_BUSINESS.state == "OR" ? 'selected' : ''}>Oregon</option>
					<option value="PA" ${THE_BUSINESS.state == "PA" ? 'selected' : ''}>Pennsylvania</option>
					<option value="RI" ${THE_BUSINESS.state == "RI" ? 'selected' : ''}>Rhode Island</option>
					<option value="SC" ${THE_BUSINESS.state == "SC" ? 'selected' : ''}>South Carolina</option>
					<option value="SD" ${THE_BUSINESS.state == "SD" ? 'selected' : ''}>South Dakota</option>
					<option value="TN" ${THE_BUSINESS.state == "TN" ? 'selected' : ''}>Tennessee</option>
					<option value="TX" ${THE_BUSINESS.state == "TX" ? 'selected' : ''}>Texas</option>
					<option value="UT" ${THE_BUSINESS.state == "UT" ? 'selected' : ''}>Utah</option>
					<option value="VT" ${THE_BUSINESS.state == "VT" ? 'selected' : ''}>Vermont</option>
					<option value="VA" ${THE_BUSINESS.state == "VA" ? 'selected' : ''}>Virginia</option>
					<option value="WA" ${THE_BUSINESS.state == "WA" ? 'selected' : ''}>Washington</option>
					<option value="WV" ${THE_BUSINESS.state == "WV" ? 'selected' : ''}>West Virginia</option>
					<option value="WI" ${THE_BUSINESS.state == "WI" ? 'selected' : ''}>Wisconsin</option>
					<option value="WY" ${THE_BUSINESS.state == "WY" ? 'selected' : ''}>Wyoming</option>
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
<!-- CATEGORY -->
			<div class="col-sm-4">	
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
			<div class="col-sm-4">
				<h5>Age Ranges*</h5>
				<div class="checkbox form-group">
					<label class="checkbox" for="allAges">
						<input type="checkbox" name="ageRange" id="allAges" value="allAges" ${BUSINESS_AGE_RANGE.allAges == true ? 'checked' : '' }> All Ages
					</label>
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
			<div class="col-sm-4">
				<h5>Best Times*</h5>
				<div class="checkbox form-group">
					<label class="checkbox" for="allDay">
						<input type="checkbox" name="bestTimes" id="allDay" value="allDay" ${BUSINESS_KID_FRIENDLY_DETAIL.allDay == true ? 'checked' : '' }> All Day
					</label>
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
		</div>
		<br />
		<div class="row">
<!-- KID FRIENDLY DETAILS - Details -->
			<div class="col-sm-12">	
				<h5>Kid Friendly Details</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="radio form-group">
					<p>Lots of Families?*</p>
					<label class="radio-inline" for="multipleFamiliesTrue">
						<input type="radio" name="multipleFamilies" id="multipleFamiliesTrue" value=1 ${BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == true ? 'checked' : '' }> Yes!
					</label>
					<label class="radio-inline" for="multipleFamiliesFalse">
						<input type="radio" name="multipleFamilies" id="multipleFamiliesFalse" value=0  ${empty BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies || BUSINESS_KID_FRIENDLY_DETAIL.multipleFamilies == false ? 'checked' : '' }> No
					</label>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="radio form-group">
					<p>Kid's Free or Kid's Discount Offered?*</p>
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
		<div class="row">
			<div class="col-sm-12">
				<p><small>Limit 255 characters</small></p>
				<div class="form-group">
					<label for="kidsFreeDiscountDetail"></label>
					<textarea class="form-control" rows="3" name="kidsFreeDiscountDetail" id="kidsFreeDiscountDetail" placeholder="Kid's Discount Details">${BUSINESS_KID_FRIENDLY_DETAIL.kidsFreeDiscountDetail}</textarea>
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
</div>
</body>
</html>