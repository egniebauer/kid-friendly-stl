package com.kidfriendlystl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.kidfriendlystl.BusinessDAO;

/**
 * Servlet implementation class FriendlyControllerServlet
 */
@WebServlet("/FriendlyControllerServlet")
public class FriendlyControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BusinessDAO businessDAO;
	private CategoryDAO categoryDAO;
	private AgeRangeDAO ageRangeDAO;
	private KidFriendlyDetailDAO kidFriendlyDetailDAO;
	private BreastfeedingInfoDAO breastfeedingInfoDAO;
	private PlayAreaDAO playAreaDAO;
	private RestaurantMenuDAO restaurantMenuDAO;
	private RestroomDAO restroomDAO;
	
	@Resource(name="jdbc/kid_friendly_stl")
	private DataSource dataSource;

	// work you'd normally do in a constructor, when you work with
	// servlets, go in an init() method
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create DAOs ... pass connection pool/datasource
		try { 
			this.businessDAO = new BusinessDAO(dataSource);
			this.categoryDAO = new CategoryDAO(dataSource);
			this.ageRangeDAO = new AgeRangeDAO(dataSource);
			this.kidFriendlyDetailDAO = new KidFriendlyDetailDAO(dataSource);
			this.breastfeedingInfoDAO = new BreastfeedingInfoDAO(dataSource);
			this.playAreaDAO = new PlayAreaDAO(dataSource);
			this.restaurantMenuDAO = new RestaurantMenuDAO(dataSource);
			this.restroomDAO = new RestroomDAO(dataSource);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listBusinesses(request, response);
				break;

			case "VIEW":
				viewBusiness(request, response);
				break;
				
			case "LOAD":
				loadBusiness(request, response);
				break;

			case "DELETE":
				deleteBusiness(request, response);
				break;		
			
			default:
				listBusinesses(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
                    
            // route to the appropriate method
            switch (theCommand) {
                            
            case "ADD":
                addBusiness(request, response);
                break;
				
			case "UPDATE":
				updateBusiness(request, response);
				break;				

//			case "SEARCH":
//				searchBusinesses(request, response);
//				break;

            default:
                listBusinesses(request, response);
            }
                
        }
        catch (Exception e) {
            throw new ServletException(e);
        }

	}
	
	private void listBusinesses(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		// get businesses from DAO
		List<Business> businesses = businessDAO.getAll();
		
		// add businesses to the request
		request.setAttribute("BUSINESS_LIST", businesses);
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-businesses.jsp");
		dispatcher.forward(request, response);
		
	}

	private void loadBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// read businessID from request
		String theBusinessID = request.getParameter("businessID");
		
		// retrieve Business from database, create necessary objects
		Business theBusiness = businessDAO.get(theBusinessID);
		Category businessCategory = categoryDAO.get(theBusinessID);
		AgeRange businessAgeRange = ageRangeDAO.get(theBusinessID);
		KidFriendlyDetail businessKidFriendlyDetail = kidFriendlyDetailDAO.get(theBusinessID);
		BreastfeedingInfo businessBreastfeedingInfo = breastfeedingInfoDAO.get(theBusinessID);
		PlayArea businessPlayArea = playAreaDAO.get(theBusinessID);
		RestaurantMenu businessRestaurantMenu = restaurantMenuDAO.get(theBusinessID);
		Restroom businessRestroom = restroomDAO.get(theBusinessID);
		
		// place Business objects in the request attribute
		request.setAttribute("THE_BUSINESS", theBusiness);
		request.setAttribute("BUSINESS_CATEGORY", businessCategory);
		request.setAttribute("BUSINESS_AGE_RANGE", businessAgeRange);
		request.setAttribute("BUSINESS_KID_FRIENDLY_DETAIL", businessKidFriendlyDetail);
		request.setAttribute("BUSINESS_BREASTFEEDING", businessBreastfeedingInfo);
		request.setAttribute("BUSINESS_PLAY_AREA", businessPlayArea);
		request.setAttribute("BUSINESS_RESTAURANT_MENU", businessRestaurantMenu);
		request.setAttribute("BUSINESS_RESTROOM", businessRestroom);
		
		// send to .jsp page: view-business.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void viewBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// read businessID from request
		String theBusinessID = request.getParameter("businessID");
		
		// retrieve Business from database, create necessary objects
		Business theBusiness = businessDAO.get(theBusinessID);
		Category businessCategory = categoryDAO.get(theBusinessID);
		AgeRange businessAgeRange = ageRangeDAO.get(theBusinessID);
		KidFriendlyDetail businessKidFriendlyDetail = kidFriendlyDetailDAO.get(theBusinessID);
		BreastfeedingInfo businessBreastfeedingInfo = breastfeedingInfoDAO.get(theBusinessID);
		PlayArea businessPlayArea = playAreaDAO.get(theBusinessID);
		RestaurantMenu businessRestaurantMenu = restaurantMenuDAO.get(theBusinessID);
		Restroom businessRestroom = restroomDAO.get(theBusinessID);
		
		// place Business objects in the request attribute
		request.setAttribute("THE_BUSINESS", theBusiness);
		request.setAttribute("BUSINESS_CATEGORY", businessCategory);
		request.setAttribute("BUSINESS_AGE_RANGE", businessAgeRange);
		request.setAttribute("BUSINESS_KID_FRIENDLY_DETAIL", businessKidFriendlyDetail);
		request.setAttribute("BUSINESS_BREASTFEEDING", businessBreastfeedingInfo);
		request.setAttribute("BUSINESS_PLAY_AREA", businessPlayArea);
		request.setAttribute("BUSINESS_RESTAURANT_MENU", businessRestaurantMenu);
		request.setAttribute("BUSINESS_RESTROOM", businessRestroom);
		
		// send to .jsp page: view-business.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-business.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// validate form input
		String errorMessage = validateForm(request);
		
		if (errorMessage.equals("PASS"))
		{
			
			// create a new Business object
			Business newBusiness = CreateTable.newBusiness(request);
			
			// check if duplicate 
			boolean dup = businessDAO.isDuplicate(newBusiness.getName());
			
			if (!dup) {
				
				// add the newBusiness to the database and retrieve its generated key
				int businessID = businessDAO.add(newBusiness);		
				
				// create other objects with businessID
				Category newCategory = CreateTable.category(businessID, request);
				AgeRange newAgeRange = CreateTable.ageRange(businessID, request);
				KidFriendlyDetail newKidFriendlyDetail = CreateTable.kidFriendlyDetail(businessID, request);
				BreastfeedingInfo newBreastfeedingInfo = CreateTable.breastfeedingInfo(businessID, request);
				PlayArea newPlayArea = CreateTable.playArea(businessID, request);
				RestaurantMenu newRestaurantMenu = CreateTable.restaurantMenu(businessID, request);
				Restroom newRestroom = CreateTable.restroom(businessID, request);				
				
				// add objects to database
				categoryDAO.add(newCategory);
				ageRangeDAO.add(newAgeRange);
				kidFriendlyDetailDAO.add(newKidFriendlyDetail);
				breastfeedingInfoDAO.add(newBreastfeedingInfo);
				playAreaDAO.add(newPlayArea);
				restaurantMenuDAO.add(newRestaurantMenu);
				restroomDAO.add(newRestroom);
				
		        // SEND AS REDIRECT to avoid multiple-browser reload issue
		        response.sendRedirect(request.getContextPath() + "/FriendlyControllerServlet?command=VIEW&businessID=" + businessID);
			
			}
			else {
			
				request.setAttribute("ERROR_MESSAGE", "Duplicate name; please verify this business is not already listed.");
				
				// send to .jsp page: oops.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/oops.jsp");
				dispatcher.forward(request, response);
			
			}
		}
		else {			
			
			request.setAttribute("ERROR_MESSAGE", errorMessage);
			
			// send to .jsp page: oops.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("/oops.jsp");
			dispatcher.forward(request, response);
		
		}
	}

	private void updateBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// validate form input
		String errorMessage = validateForm(request);
		
		if (errorMessage.equals("PASS")){
			
			Business updatedBusiness = CreateTable.existingBusiness(request);
			
			// add the business to the database and retrieve its businessID
			businessDAO.update(updatedBusiness);		
			
			// create other objects with businessID
			Category updatedCategory = CreateTable.category(updatedBusiness.getId(), request);
			AgeRange updatedAgeRange = CreateTable.ageRange(updatedBusiness.getId(), request);
			KidFriendlyDetail updatedKidFriendlyDetail = CreateTable.kidFriendlyDetail(updatedBusiness.getId(), request);
			BreastfeedingInfo updatedBreastfeedingInfo = CreateTable.breastfeedingInfo(updatedBusiness.getId(), request);
			PlayArea updatedPlayArea = CreateTable.playArea(updatedBusiness.getId(), request);
			RestaurantMenu updatedRestaurantMenu = CreateTable.restaurantMenu(updatedBusiness.getId(), request);
			Restroom updatedRestroom = CreateTable.restroom(updatedBusiness.getId(), request);				
			
			// add objects to database
			categoryDAO.update(updatedCategory);
			ageRangeDAO.update(updatedAgeRange);
			kidFriendlyDetailDAO.update(updatedKidFriendlyDetail);
			breastfeedingInfoDAO.update(updatedBreastfeedingInfo);
			playAreaDAO.update(updatedPlayArea);
			restaurantMenuDAO.update(updatedRestaurantMenu);
			restroomDAO.update(updatedRestroom);
			
	        // SEND AS REDIRECT to avoid multiple-browser reload issue
	        response.sendRedirect(request.getContextPath() + "/FriendlyControllerServlet?command=VIEW&businessID=" + updatedBusiness.getId());
		}
		else {			
			request.setAttribute("ERROR_MESSAGE", errorMessage);
			
			// send to .jsp page: oops.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("/oops.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void deleteBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// read the businessID
		String businessID = request.getParameter("businessID");
		int id = Integer.parseInt(businessID);
		
		// delete entry from database
		businessDAO.delete(id);
		
		// return home
		listBusinesses(request, response);
		
	}

	private String validateForm(HttpServletRequest request) {
		
		// default error
		String errorMessage = "Unknown Error";
		
		// read parameters - Business
		String name = request.getParameter("businessName");
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		String state = request.getParameter("businessState"); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		String rating = request.getParameter("businessRating");
		
		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");
		
		// read parameters - Category
		String[] categories = request.getParameterValues("category"); 
		
		// read parameters - AgeRange
		String[] ages = request.getParameterValues("ageRange");
		
		// read parameters - KidFriendlyDetail
		String[] bestTimes = request.getParameterValues("bestTimes");
		String multipleFamiliesRadio = request.getParameter("multipleFamilies");
		String kidsFreeDiscountRadio = request.getParameter("kidsFreeDiscount");
		String kidsFreeDiscountDetail = request.getParameter("kidsFreeDiscountDetail");
		
		//TODO - read parameters from supplemental tables
		
		// read parameters - BreastfeedingInfo
		// read parameters - PlayArea
		// read parameters - RestaurantMenu
		// read parameters - Restroom
		
		// check form data
		if (name == null || name.isEmpty() || name.length() > 45)
		{
			errorMessage = "Error with the name field.";
			return errorMessage;
		} 
		else if (address.length() > 45)
		{
			errorMessage = "Error with the address field.";
			return errorMessage;
		}
		else if (city == null || city.isEmpty() || city.length() > 45)
		{
			errorMessage = "Error with the city field.";
			return errorMessage;
		}
		else if (state == null || state.isEmpty() || state.length() > 45)
		{
			errorMessage = "Error with the state field.";
			return errorMessage;
		}
		else if (!zip.isEmpty() && (zip.length() != 5 || !zip.matches("[-+]?\\d*\\.?\\d+"))) 
		{
			errorMessage = "Error with the zip field.";
			return errorMessage;
		}
		else if (!phone.isEmpty() && (phone.length() != 10 || !phone.matches("[-+]?\\d*\\.?\\d+")))
		{
			errorMessage = "Error with the phone field.";
			return errorMessage;
		}
		else if (!website.isEmpty() && (website.length() > 45 || !website.startsWith("http://")))
		{
			errorMessage = "Error with the website field.";
			return errorMessage;
		}
		else if (rating == null) 
		{
			errorMessage = "Error with the rating selection.";
			return errorMessage;
		}
		else if (categories == null || categories.length < 1) 
		{
			errorMessage = "Error with the categories selection.";
			return errorMessage;
		}
		else if (ages == null || ages.length < 1) 
		{
			errorMessage = "Error with the age range selection.";
			return errorMessage;
		}
		else if (bestTimes == null || bestTimes.length < 1) 
		{
			errorMessage = "Error with the best time selection.";
			return errorMessage;
		}
		else if (multipleFamiliesRadio == null) 
		{
			errorMessage = "Error with the kid friendly details selection.";
			return errorMessage;
		}
		else if (kidsFreeDiscountRadio == null) 
		{
			errorMessage = "Error with the kid friendly details selection.";
			return errorMessage;
		}
		else if (kidsFreeDiscountDetail.length() > 255)
		{
			errorMessage = "Error with the kids free discount details field.";
			return errorMessage;
		}
		else {
			errorMessage = "PASS";
			return errorMessage;
		}
	}
}
