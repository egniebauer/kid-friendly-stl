package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class CreateTable {
	
	public static Breastfeeding breastfeeding(int businessID, HttpServletRequest request) 
			throws Exception {
		//TODO
		return null;
	}
	
	public static PlayArea playArea(int businessID, HttpServletRequest request) 
			throws Exception {
		//TODO
		return null;
	}
	
	public static RestaurantMenu restaurantMenu(int businessID, HttpServletRequest request) 
			throws Exception {
		//TODO
		return null;
	}
	
	public static Restroom restroom(int businessID, HttpServletRequest request) 
			throws Exception {
		//TODO
		return null;
	}
	
	public static Category category(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty Category object
		Category newCategory;
		
		// set parameters to false
		boolean activeLife = false;
		boolean artsEntertainment = false;
		boolean education = false;
		boolean foodRestaurant = false;
		boolean healthMedical = false;
		boolean hotelTravel = false;
		boolean publicServiceGovernment = false;
		boolean religious = false;
		boolean shopping = false;
		
		// retrieve form data
		String[] categories = request.getParameterValues("category"); 
		
		if (categories.length > 0) {
			
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
		
		// assign data to newCategory and return
		newCategory= new Category (businessID, activeLife, artsEntertainment, education, 
				foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment, 
				religious, shopping);
		
		return newCategory;
		
	}

	public static AgeRange ageRange(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty AgeRange object
		AgeRange newAgeRange;
		
		// set parameters to false
		boolean baby = false;
		boolean toddler = false;
		boolean preschooler = false;
		boolean gradeSchooler = false;
		boolean teen = false;
		
		// retrieve data from the form
		String[] ages = request.getParameterValues("ageRange");
		
		if (ages.length > 0){
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
		
		// assign to object and return
		newAgeRange = new AgeRange(businessID, baby, toddler, preschooler,
				gradeSchooler, teen);
		
		return newAgeRange;
		
	}

	public static KidFriendlyDetail kidFriendlyDetail(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		KidFriendlyDetail newKidFriendlyDetail;
		
		// set params to false
		boolean multipleFamilies = false;
		boolean morning = false;
		boolean afternoon = false;
		boolean evening = false;
		boolean kidsFreeDiscount = false;
		
		// retrieve data from form
		String[] bestTimes = request.getParameterValues("bestTimes");
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
		
		String multipleFamiliesRadio = request.getParameter("multipleFamilies");
		
		if (multipleFamiliesRadio.equals("1")) {
			multipleFamilies = true;
		} else if (multipleFamiliesRadio.equals("0")) {
			multipleFamilies = false;
		}
		
		String kidsFreeDiscountRadio = request.getParameter("kidsFreeDiscount");
		
		if (kidsFreeDiscountRadio.equals("1")) {
			kidsFreeDiscount = true;
		} else if (kidsFreeDiscountRadio.equals("0")) {
			kidsFreeDiscount = false;
		}
		
		String kidsFreeDiscountDetail = request.getParameter("kidsFreeDiscountDetail");
		
		// assign to object and return
		newKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, morning,
				afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		
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
		int rating = Integer.parseInt(request.getParameter("businessRating"));

		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");
				
		// rating breakdown
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
		int rating = Integer.parseInt(request.getParameter("businessRating"));

		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");

		// rating breakdown
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

		// create new business object (with existing id)
		Business newBusiness = new Business(id, name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
		
		// return business
		return newBusiness;

	}

}
