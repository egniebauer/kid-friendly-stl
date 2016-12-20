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

<title>Add New Listing</title>

</head>
<body>
	<div class="container-fluid">

		<h1>Kid Friendly STL  <small>Add New Listing</small></h1>

		<br />
		
		<form action="FriendlyControllerServlet" method="POST">
			<input type="hidden" name="command" value="ADD" />
		<!-- Business -->
			<div class="form-group">
				<label for="business">Contact Information</label>
				<input type="text" class="form-control" name="businessName" id="businessName" placeholder="Name">
				<br />
				<input type="text" class="form-control" name="businessAddress" id="businessAddress" placeholder="Address">
				<input type="text" class="form-control" name="businessCity" id="businessCity" placeholder="City" value="Saint Louis">
				<input type="text" class="form-control" name="businessState" id="businessState" placeholder="State" value="MO">
				<input type="text" class="form-control" name="businessZip" id="businessZip" placeholder="Zip">
				<br />
				<input type="tel" class="form-control" name="businessPhone" id="businessPhone" placeholder="Phone">
				<input type="text" class="form-control" name="businessWebsite" id="businessWebsite" placeholder="Website">
			</div>
			
			<br />
			
		<!-- Category -->
				<label for="category">Categories</label>
				<p><small>Please select at least one category:</small></p>
			<div class="checkbox">
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="activeLife" value="activeLife"> Active Life
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="artsEntertainment" value="artsEntertainment"> Arts & Entertainment
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="education" value="education"> Education
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="foodRestaurant" value="foodRestaurant"> Food & Restaurant
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="healthMedical" value="healthMedical"> Health & Medical
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="hotelTravel" value="hotelTravel"> Hotels & Travel
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="publicServiceGovernment" value="publicServiceGovernment"> Public Services
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="religious" value="religious"> Religious
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="category" id="shopping" value="shopping"> Shopping
				</label>
			</div>
			
			<br />

		<!-- Age Ranges -->
				<label for="ageRange">Age Ranges</label>
				<p><small>Please select at least one age group:</small></p>
			<div class="checkbox">
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="allAges" value="allAges"> All Ages
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="baby" value="baby"> Baby
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="toddler" value="toddler"> Toddler
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="preschooler" value="preschooler"> Preschooler
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="gradeSchooler" value="gradeSchooler"> Grade Schooler
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="ageRange" id="teen" value="teen"> Teen
				</label>
			</div>

			<br />

		<!-- KID FRIENDLY DETAILS - Best Times -->
				<label for="bestTimes">Best Times</label>
				<p><small>Please select at least one time:</small></p>
			<div class="checkbox">
				<label class="checkbox-inline">
					<input type="checkbox" name="bestTimes" id="allDay" value="allDay"> All Day
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="bestTimes" id="morning" value="morning"> Morning
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="bestTimes" id="afternoon" value="afternoon"> Afternoon
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="bestTimes" id="evening" value="evening"> Evening
				</label>
			</div>

			<br />

		<!-- KID FRIENDLY DETAILS -->
				<label for="kidFriendlyDetails">Kid Friendly Details</label>
			<div class="radio">
				Lots of Families?  
				<label class="radio-inline">
					<input type="radio" name="multipleFamilies" id="multipleFamiliesTrue" value=1>
					Yes!
				</label>
				<label class="radio-inline">
					<input type="radio" name="multipleFamilies" id="multipleFamiliesFalse" value=0 checked>
					No
				</label>
			</div>
			<div class="radio">
				Kid's Free or Kid's Discount Offered?  
				<label class="radio-inline">
					<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountTrue" value=1>
					Yes!
				</label>
				<label class="radio-inline">
					<input type="radio" name="kidsFreeDiscount" id="kidsFreeDiscountFalse" value=0 checked>
					No
				</label>
				<br /> <br />
				<textarea class="form-control" rows="3" name="kidsFreeDiscountDetail" id="kidsFreeDiscountDetail" placeholder="Kid's Discount Details"></textarea>
				<p><small>Limit 255 characters</small></p>
			</div>

			<br />

		<!-- Buttons -->
			<input class="btn btn-default" type="submit" value="Submit">
			<a class="btn btn-danger" href="FriendlyControllerServlet" role="button">
				Cancel</a>
			
			<br />

		</form>	  

	<br />

	</div>
</body>
</html>