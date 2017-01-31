package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class CreateTable {
	
	public static BreastfeedingInfo breastfeedingInfo(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty Category object
		BreastfeedingInfo newBreastfeedingInfo;
				
		// retrieve form data		
		String breastfeedingCleanRadio = request.getParameter("breastfeedingClean");
		String comfortableRadio = request.getParameter("comfortable");
		String bottleWarmerRadio = request.getParameter("bottleWarmer");
		String[] breastfeedingLocations = request.getParameterValues("poppingBoobs"); 

		// assign data to parameters
		Boolean clean = null;
		if (breastfeedingCleanRadio != null) {
			clean = breastfeedingCleanRadio.equals("1") ? true : false;
		}
		Boolean comfortable = null;
		if (comfortableRadio != null) {
			comfortable = comfortableRadio.equals("1") ? true : false;
		}
		Boolean bottleWarmer = null;
		if (bottleWarmerRadio != null) {
			bottleWarmer = bottleWarmerRadio.equals("1") ? true : false;
		}
		
		boolean lactationRoom = false;
		boolean quietArea = false;
		boolean grossOpts = false;
		boolean nonSpecificOpts = false;
		if (breastfeedingLocations != null) {
			for (String location : breastfeedingLocations) {
				switch (location) {
					case "lactationRoom":
						lactationRoom = true;
						break;
					case "quietArea":
						quietArea = true;
						break;
					case "grossOpts":
						grossOpts = true;
						break;
					case "nonSpecificOpts":
						nonSpecificOpts = true;
						break;
				}
			}
		}
		
		// pass parameters to object and return
		newBreastfeedingInfo = new BreastfeedingInfo (businessID, clean, comfortable, bottleWarmer, lactationRoom, quietArea, grossOpts, nonSpecificOpts);
		return newBreastfeedingInfo;
	}
	
	public static PlayAreaInfo playAreaInfo(int businessID, HttpServletRequest request) 
			throws Exception {
		// create empty object
		PlayAreaInfo newPlayAreaInfo;
		
		// retrieve data from form
		String playAreaCleanRadio = request.getParameter("playAreaClean");
		String gatedRadio = request.getParameter("gated");
		String funRadio = request.getParameter("fun");
		String[] locations = request.getParameterValues("location");

		// set parameters 
		Boolean clean = null;
		if (playAreaCleanRadio != null) {
			clean = playAreaCleanRadio.equals("1") ? true : false;
		}
		Boolean gated = null;
		if (gatedRadio != null) {
			gated = gatedRadio.equals("1") ? true : false;
		}
		Boolean fun = null;
		if (funRadio != null) {
			fun = funRadio.equals("1") ? true : false;
		}
		
		boolean inside = false;
		boolean outside = false;
		if (locations != null) {
			for (String location : locations) {
				switch (location){
					case "inside":
						inside = true;
						break;
					case "outside":
						outside = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newPlayAreaInfo = new PlayAreaInfo(businessID, clean, inside, outside, gated, fun);
		return newPlayAreaInfo;
	}
	
	public static RestaurantMenuInfo restaurantMenuInfo(int businessID, HttpServletRequest request) 
			throws Exception {
		// create empty object
		RestaurantMenuInfo newRestaurantMenuInfo;
		
		// retrieve data
		String activitiesRadio = request.getParameter("activities");
		String[] seatingOptions = request.getParameterValues("seating");
		String[] kidsMenu = request.getParameterValues("kidsMenu");
		String[] fullMenu = request.getParameterValues("fullMenu");
		
		// set data to params
		Boolean activities = null;
		if (activitiesRadio != null) {
			activities = activitiesRadio.equals("1") ? true : false;
		}

		boolean highChair = false;
		boolean booster = false;
		if (seatingOptions != null){
			for (String option : seatingOptions) {
				switch (option){
					case "highChair" :
						highChair = true;
						break;
					case "booster" :
						booster = true;
						break;
				}
			}
		}
		
		boolean healthy = false;
		boolean allergyFriendly = false;
		boolean unhealthy = false;
		boolean noKidsMenu = false;		
		if (kidsMenu != null) {
			for (String option : kidsMenu) {
				switch (option){
					case "healthy" :
						healthy = true;
						break;
					case "allergyFriendly" :
						allergyFriendly = true;
						break;
					case "unhealthy" :
						unhealthy = true;
						break;
					case "noKidsMenu" :
						noKidsMenu = true;
						break;
				}
			}
		}
		
		boolean manyOpts = false;
		boolean someOpts = false;
		boolean fewOpts = false;
		boolean noOpts = false;	
		if (fullMenu != null) {
			for (String option : fullMenu) {
				switch (option){
					case "manyOpts" :
						manyOpts = true;
						break;
					case "someOpts" :
						someOpts = true;
						break;
					case "fewOpts" :
						fewOpts = true;
						break;
					case "noOpts" :
						noOpts = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newRestaurantMenuInfo = new RestaurantMenuInfo(businessID, highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
		return newRestaurantMenuInfo;
	}
	
	public static RestroomInfo restroomInfo(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		RestroomInfo newRestroomInfo;
		
		// retrieve data
		String restroomCleanRadio = request.getParameter("restroomClean");
		String toddlerSeatRadio = request.getParameter("toddlerSeat");
		String handDryerRadio = request.getParameter("handDryer");
		String[] changingTables = request.getParameterValues("changingTable");
		
		// set data to params
		Boolean clean = null;
		if (restroomCleanRadio != null) {
			clean = restroomCleanRadio.equals("1") ? true : false;
		}
		Boolean toddlerSeat = null;
		if (toddlerSeatRadio != null) {
			toddlerSeat = toddlerSeatRadio.equals("1") ? true : false;
		}
		Boolean handDryer = null;
		if (handDryerRadio != null) {
			handDryer = handDryerRadio.equals("1") ? true : false;
		}

		boolean womensRoom = false;
		boolean mensRoom = false;
		boolean familyRoom = false;
		boolean noChangingTable = false;
		if (changingTables != null){
			for (String table : changingTables) {
				switch (table){
					case "womensRoom" :
						womensRoom = true;
						break;
					case "mensRoom" :
						mensRoom = true;
						break;
					case "familyRoom" :
						familyRoom = true;
						break;
					case "noChangingTable" :
						noChangingTable = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newRestroomInfo = new RestroomInfo(businessID, clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
		return newRestroomInfo;
	}
	
	public static Category category(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty Category object
		Category newCategory;
		
		// retrieve form data
		String[] categories = request.getParameterValues("category"); 
		
		// assign data to params
		boolean activeLife = false;
		boolean artsEntertainment = false;
		boolean education = false;
		boolean foodRestaurant = false;
		boolean healthMedical = false;
		boolean hotelTravel = false;
		boolean publicServiceGovernment = false;
		boolean religious = false;
		boolean shopping = false;
		
		if (categories != null) {
			for (String category : categories) {
				switch (category) {
					case "activeLife":
						activeLife = true;
						break;
					case "artsEntertainment":
						artsEntertainment = true;
						break;
					case "education":
						education = true;
						break;
					case "foodRestaurant":
						foodRestaurant = true;
						break;
					case "healthMedical":
						healthMedical = true;
						break;
					case "hotelTravel":
						hotelTravel = true;
						break;
					case "publicServiceGovernment":
						publicServiceGovernment = true;
						break;
					case "religious":
						religious = true;
						break;
					case "shopping":
						shopping = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newCategory= new Category (businessID, activeLife, artsEntertainment, education, foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment, religious, shopping);
		return newCategory;
	}

	public static AgeRange ageRange(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty AgeRange object
		AgeRange newAgeRange;
		
		// retrieve data from the form
		String[] ages = request.getParameterValues("ageRange");
		
		//set params
		boolean baby = false;
		boolean toddler = false;
		boolean preschooler = false;
		boolean gradeSchooler = false;
		boolean teen = false;

		if (ages != null){
			for (String age: ages){
				switch (age) {
					case "baby":
						baby = true;
						break;
					case "toddler":
						toddler = true;
						break;
					case "preschooler":
						preschooler = true;
						break;
					case "gradeSchooler":
						gradeSchooler = true;
						break;
					case "teen":
						teen = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newAgeRange = new AgeRange(businessID, baby, toddler, preschooler, gradeSchooler, teen);
		return newAgeRange;
	}

	public static KidFriendlyDetail kidFriendlyDetail(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		KidFriendlyDetail newKidFriendlyDetail;
		
		// set params to false
		
		// retrieve data from form
		String multipleFamiliesRadio = request.getParameter("multipleFamilies");
		String kidsFreeDiscountRadio = request.getParameter("kidsFreeDiscount");
		String kidsFreeDiscountDetail = request.getParameter("kidsFreeDiscountDetail");
		String[] bestTimes = request.getParameterValues("bestTimes");

		// set params
		Boolean multipleFamilies = null;
		if (multipleFamiliesRadio != null) {
			multipleFamilies = multipleFamiliesRadio.equals("1") ? true : false;
		}
		Boolean kidsFreeDiscount = null;
		if (kidsFreeDiscountRadio !=null) {
			kidsFreeDiscount = kidsFreeDiscountRadio.equals("1") ? true : false;
		}
		
		boolean morning = false;
		boolean afternoon = false;
		boolean evening = false;
		if (bestTimes != null) {
			for (String time : bestTimes) {
				switch (time) {
					case "morning":
						morning = true;
						break;
					case "afternoon":
						afternoon = true;
						break;
					case "evening":
						evening = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, morning, afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		return newKidFriendlyDetail;
	}

	public static Business newBusiness(HttpServletRequest request) {
		
		// read form data
		String name = request.getParameter("businessName");
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		State state = State.valueOf(request.getParameter("businessState")); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		String businessRating = request.getParameter("businessRating");

		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");
				
		// rating breakdown
		int rating = businessRating != null ? Integer.parseInt(businessRating) : 0;
		
		int rating1 = 0;
		int rating2 = 0;
		int rating3 = 0;
		int rating4 = 0;
		int rating5 = 0;
		
		switch (rating) {
			case 1:	rating1 = 1;
					break;
			case 2:	rating2 = 1;
					break;
			case 3:	rating3 = 1;
					break;
			case 4:	rating4 = 1;
					break;
			case 5:	rating5 = 1;
					break;
		}

		// create new business object (without existing id)
		Business newBusiness =  new Business(name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
		
		// return business
		return newBusiness;
	}

	public static Business existingBusiness(HttpServletRequest request) {
		
		// read form data
		String businessID = request.getParameter("businessID");
		int id = Integer.parseInt(businessID);
		String name = request.getParameter("businessName");
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		State state = State.valueOf(request.getParameter("businessState")); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		String businessRating = request.getParameter("businessRating");

		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");

		// rating breakdown
		int rating = businessRating != null ? Integer.parseInt(businessRating) : 0;
		
		int rating1 = 0;
		int rating2 = 0;
		int rating3 = 0;
		int rating4 = 0;
		int rating5 = 0;
		
		switch (rating) {
			case 1:	rating1 = 1;
					break;
			case 2:	rating2 = 1;
					break;
			case 3:	rating3 = 1;
					break;
			case 4:	rating4 = 1;
					break;
			case 5:	rating5 = 1;
					break;
		}

		// create business object (with existing id)
		Business existingBusiness = new Business(id, name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
		
		// return business
		return existingBusiness;
	}

}
