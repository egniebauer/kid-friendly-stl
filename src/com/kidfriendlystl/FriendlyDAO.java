package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class FriendlyDAO {

	private DataSource dataSource;

	public FriendlyDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Business> getBusinesses() 
			throws Exception {
		
		// create empty list
		List<Business> businesses = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.business";
			myStmt = myConn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int id = myRS.getInt("id");
				String name = myRS.getString("name");
				String address = myRS.getString("address");
				String city = myRS.getString("city");
				String state = myRS.getString("state");
				String zip = myRS.getString("zip");
				String phone = myRS.getString("phone");
				String website = myRS.getString("website");
				
				// create new Business object
				Business currentBusiness = new Business(id, name, address, city, state, zip, phone, website);
				
				// add Student object to list
				businesses.add(currentBusiness);
			}
			// return list
			return businesses;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRS) {
		try {
			if (myRS != null) {
				myRS.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();	// doesn't really close ... returns it to connection pool
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Category> getCategories() 
			throws Exception {
		
		// create empty list
		List<Category> categories = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.category";
			myStmt = myConn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int businessID = myRS.getInt("business_id");
				boolean activeLife = myRS.getBoolean("active_life");
				boolean artsEntertainment = myRS.getBoolean("arts_entertainment");
				boolean education = myRS.getBoolean("education");
				boolean foodRestaurant = myRS.getBoolean("food_restaurant");
				boolean healthMedical = myRS.getBoolean("health_medical");
				boolean hotelTravel = myRS.getBoolean("hotel_travel");
				boolean publicServiceGovernment = myRS.getBoolean("public_service_government");
				boolean religious = myRS.getBoolean("religious");
				boolean shopping = myRS.getBoolean("shopping");
				
				// create new Business object
				Category currentBusiness = new Category(businessID,  activeLife,  artsEntertainment,  education,
						 foodRestaurant,  healthMedical,  hotelTravel,  publicServiceGovernment,
						 religious,  shopping);
				
				// add Student object to list
				categories.add(currentBusiness);
			}
			// return list
			return categories;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public List<AgeRange> getAges() 
			throws Exception {
		
		// create empty list
		List<AgeRange> ages = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.age_range";
			myStmt = myConn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int businessID = myRS.getInt("business_id");
				boolean allAges = myRS.getBoolean("all_ages");
				boolean baby = myRS.getBoolean("baby");
				boolean gradeSchooler = myRS.getBoolean("grade_schooler");
				boolean preschooler = myRS.getBoolean("preschooler");
				boolean teen = myRS.getBoolean("teen");
				boolean toddler = myRS.getBoolean("toddler");
				
				// create new Business object
				AgeRange currentAgeRange = new AgeRange(businessID, allAges, baby, toddler, preschooler,
						 gradeSchooler, teen);
				
				// add Student object to list
				ages.add(currentAgeRange);
			}
			// return list
			return ages;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public Business getBusiness(String theBusinessID) 
			throws Exception{
		
		// create empty Business and int businessID
		Business theBusiness = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theBusiness
			String sql = "SELECT * FROM kid_friendly_stl.business WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty Business
			if (myRS.next()) {
				String name = myRS.getString("name"); 
				String address = myRS.getString("address"); 
				String city = myRS.getString("city"); 
				String state = myRS.getString("state"); 
				String zip = myRS.getString("zip");
				String phone = myRS.getString("phone"); 
				String website = myRS.getString("website");
				
				theBusiness = new Business(businessID, name, address, city, state, zip,
						phone, website);
			}
			else {
				throw new Exception("Could not find business id: " + businessID);
			}
			
			// return Business
			return theBusiness;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public Category getCategory(String theBusinessID) 
			throws Exception {
		
		// create empty Category and int businessID
		Category theCategory = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theCategory
			String sql = "SELECT * FROM kid_friendly_stl.category WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty Category
			if (myRS.next()) {
				boolean activeLife = myRS.getBoolean("active_life");
				boolean artsEntertainment = myRS.getBoolean("arts_entertainment");
				boolean education = myRS.getBoolean("education");
				boolean foodRestaurant = myRS.getBoolean("food_restaurant");
				boolean healthMedical = myRS.getBoolean("health_medical");
				boolean hotelTravel = myRS.getBoolean("hotel_travel");
				boolean publicServiceGovernment = myRS.getBoolean("public_service_government");
				boolean religious = myRS.getBoolean("religious");
				boolean shopping = myRS.getBoolean("shopping"); 
				
				theCategory = new Category(businessID, activeLife, artsEntertainment, education,
						foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment,
						religious, shopping);
			}
			else {
				throw new Exception("Could not find category id: " + businessID);
			}
			
			// return Category
			return theCategory;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public AgeRange getAgeRange(String theBusinessID) 
			throws Exception {
		
		// create empty AgeRange and int businessID
		AgeRange theAgeRange = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinesstID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theAgeRage
			String sql = "SELECT * FROM kid_friendly_stl.age_range WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (myRS.next()) {
				boolean allAges = myRS.getBoolean("all_ages");
				boolean baby = myRS.getBoolean("baby");
				boolean toddler = myRS.getBoolean("toddler");
				boolean preschooler = myRS.getBoolean("preschooler");
				boolean gradeSchooler = myRS.getBoolean("grade_schooler");
				boolean teen = myRS.getBoolean("teen");
				
				theAgeRange = new AgeRange(businessID, allAges, baby, toddler, preschooler,
						gradeSchooler, teen);
			}
			else {
				throw new Exception("Could not find age rage id: " + businessID);
			}
			
			// return AgeRage
			return theAgeRange;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public KidFriendlyDetail getKidFriendlyDetail(String theBusinessID) 
			throws Exception {
		
		// create empty KidFriendlyDetail and int businessID
		KidFriendlyDetail theKidFriendlyDetail = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinesstID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theKidFriendlyDetail
			String sql = "SELECT * FROM kid_friendly_stl.kid_friendly_detail WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (myRS.next()) {
				boolean multipleFamilies = myRS.getBoolean("multiple_families");
				boolean allDay = myRS.getBoolean("all_day");
				boolean morning = myRS.getBoolean("morning");
				boolean afternoon = myRS.getBoolean("afternoon"); 
				boolean evening = myRS.getBoolean("evening"); 
				boolean kidsFreeDiscount = myRS.getBoolean("kids_free_discount");
				String kidsFreeDiscountDetail = myRS.getString("kids_free_discount_detail");
				
				theKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, allDay, morning,
						afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
			}
			else {
				throw new Exception("Could not find kid friendly detail id: " + businessID);
			}
			
			// return AgeRage
			return theKidFriendlyDetail;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public int addBusiness(Business newBusiness) 
			throws Exception {
		
		int businessID = 0;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.business "
					+ "(name, address, city, state, zip, phone, website) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// set param values
			myStmt.setString(1, newBusiness.getName());
			myStmt.setString(2, newBusiness.getAddress());
			myStmt.setString(3, newBusiness.getCity());
			myStmt.setString(4, newBusiness.getState());
			myStmt.setString(5, newBusiness.getZip());
			myStmt.setString(6, newBusiness.getPhone());
			myStmt.setString(7, newBusiness.getWebsite());
			
			// execute SQL INSERT
			myStmt.execute();
			myRS = myStmt.getGeneratedKeys();

			// create int for business id
			if(myRS.next()) {
				   businessID = myRS.getInt(1);
				}			
			return businessID;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}

	}

	public void addCategory(Category newCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.category "
					+ "(business_id, active_life, arts_entertainment, education, food_restaurant, health_medical, hotel_travel, public_service_government, religious, shopping) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newCategory.getBusinessID());
			myStmt.setBoolean(2, newCategory.isActiveLife());
			myStmt.setBoolean(3, newCategory.isArtsEntertainment());
			myStmt.setBoolean(4, newCategory.isEducation());
			myStmt.setBoolean(5, newCategory.isFoodRestaurant());
			myStmt.setBoolean(6, newCategory.isHealthMedical());
			myStmt.setBoolean(7, newCategory.isHotelTravel());
			myStmt.setBoolean(8, newCategory.isPublicServiceGovernment());
			myStmt.setBoolean(9, newCategory.isReligious());
			myStmt.setBoolean(10, newCategory.isShopping());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}

	public void addAgeRange(AgeRange newAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.age_range "
					+ "(business_id, all_ages, baby, toddler, preschooler, grade_schooler, teen) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newAgeRange.getBusinessID());
			myStmt.setBoolean(2, newAgeRange.isAllAges());
			myStmt.setBoolean(3, newAgeRange.isBaby());
			myStmt.setBoolean(4, newAgeRange.isToddler());
			myStmt.setBoolean(5, newAgeRange.isPreschooler());
			myStmt.setBoolean(6, newAgeRange.isGradeSchooler());
			myStmt.setBoolean(7, newAgeRange.isTeen());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}

	public void addKidFriendlyDetail(KidFriendlyDetail newKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.kid_friendly_detail "
					+ "(business_id, multiple_families, all_day, morning, afternoon, evening, kids_free_discount, kids_free_discount_detail) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newKidFriendlyDetail.getBusinessID());
			myStmt.setBoolean(2, newKidFriendlyDetail.isMultipleFamilies());
			myStmt.setBoolean(3, newKidFriendlyDetail.isAllDay());
			myStmt.setBoolean(4, newKidFriendlyDetail.isMorning());
			myStmt.setBoolean(5, newKidFriendlyDetail.isAfternoon());
			myStmt.setBoolean(6, newKidFriendlyDetail.isEvening());
			myStmt.setBoolean(7, newKidFriendlyDetail.isKidsFreeDiscount());
			myStmt.setString(8, newKidFriendlyDetail.getKidsFreeDiscountDetail());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}
	
	public void updateBusiness(Business updatedBusiness) 
			throws Exception {
				
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.business "
					+ "SET name=?, address=?, city=?, state=?, zip=?, phone=?, website=? "
					+ "WHERE id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setString(1, updatedBusiness.getName());
			myStmt.setString(2, updatedBusiness.getAddress());
			myStmt.setString(3, updatedBusiness.getCity());
			myStmt.setString(4, updatedBusiness.getState());
			myStmt.setString(5, updatedBusiness.getZip());
			myStmt.setString(6, updatedBusiness.getPhone());
			myStmt.setString(7, updatedBusiness.getWebsite());
			myStmt.setInt(8, updatedBusiness.getId());
			
			// execute SQL INSERT
			myStmt.execute();

		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public void updateCategory(Category updatedCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.category "
					+ "SET active_life=?, arts_entertainment=?, education=?, food_restaurant=?, health_medical=?, hotel_travel=?, public_service_government=?, religious=?, shopping=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedCategory.isActiveLife());
			myStmt.setBoolean(2, updatedCategory.isArtsEntertainment());
			myStmt.setBoolean(3, updatedCategory.isEducation());
			myStmt.setBoolean(4, updatedCategory.isFoodRestaurant());
			myStmt.setBoolean(5, updatedCategory.isHealthMedical());
			myStmt.setBoolean(6, updatedCategory.isHotelTravel());
			myStmt.setBoolean(7, updatedCategory.isPublicServiceGovernment());
			myStmt.setBoolean(8, updatedCategory.isReligious());
			myStmt.setBoolean(9, updatedCategory.isShopping());
			myStmt.setInt(10, updatedCategory.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}

	public void updateAgeRange(AgeRange updatedAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.age_range "
					+ "SET all_ages=?, baby=?, toddler=?, preschooler=?, grade_schooler=?, teen=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedAgeRange.isAllAges());
			myStmt.setBoolean(2, updatedAgeRange.isBaby());
			myStmt.setBoolean(3, updatedAgeRange.isToddler());
			myStmt.setBoolean(4, updatedAgeRange.isPreschooler());
			myStmt.setBoolean(5, updatedAgeRange.isGradeSchooler());
			myStmt.setBoolean(6, updatedAgeRange.isTeen());
			myStmt.setInt(7, updatedAgeRange.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}
	
	public void updateKidFriendlyDetail(KidFriendlyDetail updatedKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.kid_friendly_detail "
					+ "SET multiple_families=?, all_day=?, morning=?, afternoon=?, evening=?, kids_free_discount=?, kids_free_discount_detail=? "
					+ "WHERE business_id=? ";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedKidFriendlyDetail.isMultipleFamilies());
			myStmt.setBoolean(2, updatedKidFriendlyDetail.isAllDay());
			myStmt.setBoolean(3, updatedKidFriendlyDetail.isMorning());
			myStmt.setBoolean(4, updatedKidFriendlyDetail.isAfternoon());
			myStmt.setBoolean(5, updatedKidFriendlyDetail.isEvening());
			myStmt.setBoolean(6, updatedKidFriendlyDetail.isKidsFreeDiscount());
			myStmt.setString(7, updatedKidFriendlyDetail.getKidsFreeDiscountDetail());
			myStmt.setInt(8, updatedKidFriendlyDetail.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
	}

	public void deleteBusiness(int id) throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create SQL and PreparedStatement to DELETE student
			String sql = "DELETE FROM kid_friendly_stl.business WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public boolean isDuplicate(String name) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create SQL and PreparedStatement to DELETE student
			String sql = "SELECT * FROM kid_friendly_stl.business WHERE name=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, name);
			
			// execute SQL statement
			myRS = myStmt.executeQuery();
			
			// return boolean
			if (myRS.next()){
				return true;
			} else {
				return false;
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
}
