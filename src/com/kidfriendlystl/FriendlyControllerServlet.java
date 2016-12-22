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
	
	private void deleteBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// read the businessID
		int id = Integer.parseInt(request.getParameter("businessID"));
		
		// delete entry from database
		businessDAO.delete(id);
		
		// return home
		listBusinesses(request, response);
	}

	private void updateBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// validate form input
		String errorMessage = validateForm(request);
		
		if (errorMessage.equals("PASS")){
			
			// read form data
			int id = Integer.parseInt(request.getParameter("businessID"));
			String name = request.getParameter("businessName"); 
			String address = request.getParameter("businessAddress");
			String city = request.getParameter("businessCity");
			String state = request.getParameter("businessState"); 
			String zip = request.getParameter("businessZip");
			String phone = request.getParameter("businessPhone");
			String website = request.getParameter("businessWebsite");
			
			// create a new Business object
			Business updatedBusiness = new Business(id, name, address, city, state, zip,
					phone, website);
			
			// add the business to the database and retrieve its businessID
			businessDAO.update(updatedBusiness);		
			
			// create other objects with businessID
			Category updatedCategory = createCategory(id, request);
			AgeRange updatedAgeRange = createAgeRange(id, request);
			KidFriendlyDetail updatedKidFriendlyDetail = createKidFriendlyDetail(id, request);
			
			// add objects to database
			categoryDAO.update(updatedCategory);
			ageRangeDAO.update(updatedAgeRange);
			kidFriendlyDetailDAO.update(updatedKidFriendlyDetail);
			
	        // SEND AS REDIRECT to avoid multiple-browser reload issue
	        response.sendRedirect(request.getContextPath() + "/FriendlyControllerServlet?command=VIEW&businessID=" + id);
		}
		else {			
			request.setAttribute("ERROR_MESSAGE", errorMessage);
			
			// send to .jsp page: oops.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("/oops.jsp");
			dispatcher.forward(request, response);
		}
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
		
		// place Business objects in the request attribute
		request.setAttribute("THE_BUSINESS", theBusiness);
		request.setAttribute("BUSINESS_CATEGORY", businessCategory);
		request.setAttribute("BUSINESS_AGE_RANGE", businessAgeRange);
		request.setAttribute("BUSINESS_KID_FRIENDLY_DETAIL", businessKidFriendlyDetail);
		
		// send to .jsp page: view-business.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-business-form.jsp");
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
		
		// place Business objects in the request attribute
		request.setAttribute("THE_BUSINESS", theBusiness);
		request.setAttribute("BUSINESS_CATEGORY", businessCategory);
		request.setAttribute("BUSINESS_AGE_RANGE", businessAgeRange);
		request.setAttribute("BUSINESS_KID_FRIENDLY_DETAIL", businessKidFriendlyDetail);
		
		// send to .jsp page: view-business.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-business.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void listBusinesses(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		// get businesses from DAO
		List<Business> businesses = businessDAO.getAll();
		List<Category> categories = categoryDAO.getAll();
		List<AgeRange> ages = ageRangeDAO.getAll();
		
		// add businesses to the request
		request.setAttribute("BUSINESS_LIST", businesses);
		request.setAttribute("CATEGORY_LIST", categories);
		request.setAttribute("AGE_LIST", ages);
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-businesses.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addBusiness(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// validate form input
		String errorMessage = validateForm(request);
		
		if (errorMessage.equals("PASS"))
		{
			// read form data
			String name = request.getParameter("businessName"); 
			String address = request.getParameter("businessAddress");
			String city = request.getParameter("businessCity");
			String state = request.getParameter("businessState"); 
			String zip = request.getParameter("businessZip");
			String phone = request.getParameter("businessPhone");
			String website = request.getParameter("businessWebsite");
			
			// check if duplicate 
			boolean dup = businessDAO.isDuplicate(name);
			
			if (!dup) {
				// create a new Business object
				Business newBusiness = new Business(name, address, city, state, zip,
						phone, website);
				
				// add the business to the database and retrieve its businessID
				int businessID = businessDAO.add(newBusiness);		
				
				// create other objects with businessID
				Category newCategory = createCategory(businessID, request);
				AgeRange newAgeRange = createAgeRange(businessID, request);
				KidFriendlyDetail newKidFriendlyDetail = createKidFriendlyDetail(businessID, request);
				
				// add objects to database
				categoryDAO.add(newCategory);
				ageRangeDAO.add(newAgeRange);
				kidFriendlyDetailDAO.add(newKidFriendlyDetail);
				
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

	private String validateForm(HttpServletRequest request) {
		String errorMessage = "Unknown Error";
		
		// read parameters - Business
		String name = request.getParameter("businessName");		
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		String state = request.getParameter("businessState"); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		// read parameters - Category
		String[] categories = request.getParameterValues("category"); 
		// read parameters - AgeRange
		String[] ages = request.getParameterValues("ageRange");
		// read parameters - KidFriendlyDetail
		String[] bestTimes = request.getParameterValues("bestTimes");
		String multipleFamiliesRadio = request.getParameter("multipleFamilies");
		String kidsFreeDiscountRadio = request.getParameter("kidsFreeDiscount");
		String kidsFreeDiscountDetail = request.getParameter("kidsFreeDiscountDetail");
		
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
		else if (website.length() > 45)
		{
			errorMessage = "Error with the website field.";
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
		
		//return errorMessage;
	}

	private KidFriendlyDetail createKidFriendlyDetail(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		KidFriendlyDetail newKidFriendlyDetail;
		
		// set params to false
		boolean multipleFamilies = false;
		boolean allDay = false;
		boolean morning = false;
		boolean afternoon = false;
		boolean evening = false;
		boolean kidsFreeDiscount = false;
		
		// retrieve data from form
		String[] bestTimes = request.getParameterValues("bestTimes");
		for (String time : bestTimes) {
			switch (time) {
				case "allDay":
					allDay = true;
					break;
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
		newKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, allDay, morning,
				afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		
		return newKidFriendlyDetail;
	}

	private AgeRange createAgeRange(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty AgeRange object
		AgeRange newAgeRange;
		
		// set parameters to false
		boolean allAges = false;
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
					case "allAges":
						allAges = true;
						break;
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
		
		// assign those values to the parameters
		newAgeRange = new AgeRange(businessID, allAges, baby, toddler, preschooler,
				gradeSchooler, teen);
		
		// return the new object
		return newAgeRange;
	}

	
	private Category createCategory(int businessID, HttpServletRequest request) 
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
		
		// assign data to newCategory
		newCategory= new Category (businessID, activeLife, artsEntertainment, education, 
				foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment, 
				religious, shopping);
		
		// return newCategory
		return newCategory;
	}

}
