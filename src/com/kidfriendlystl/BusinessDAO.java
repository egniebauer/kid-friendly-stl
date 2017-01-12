package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class BusinessDAO {

	private DataSource dataSource;

	public BusinessDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
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

	public List<Business> getAll() 
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
				State state = State.valueOf(myRS.getString("state"));
				String zip = myRS.getString("zip");
				String phone = myRS.getString("phone");
				String website = myRS.getString("website");
				int rating1 = myRS.getInt("rating1");
				int rating2 = myRS.getInt("rating2");
				int rating3 = myRS.getInt("rating3");
				int rating4 = myRS.getInt("rating4");
				int rating5 = myRS.getInt("rating5");
				
				// create new Business object
				Business currentBusiness = new Business(id, name, address, city, state, zip, 
						phone, website, rating1, rating2, rating3, rating4, rating5);
				
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

	public Business get(String theBusinessID) 
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
				State state = State.valueOf(myRS.getString("state")); 
				String zip = myRS.getString("zip");
				String phone = myRS.getString("phone"); 
				String website = myRS.getString("website");
				int rating1 = myRS.getInt("rating1");
				int rating2 = myRS.getInt("rating2");
				int rating3 = myRS.getInt("rating3");
				int rating4 = myRS.getInt("rating4");
				int rating5 = myRS.getInt("rating5");
				
				theBusiness = new Business(businessID, name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
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

	public int add(Business newBusiness) 
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
					+ "(name, address, city, state, zip, phone, website, rating1, rating2, rating3, rating4, rating5) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// set param values
			myStmt.setString(1, newBusiness.getName());
			myStmt.setString(2, newBusiness.getAddress());
			myStmt.setString(3, newBusiness.getCity());
			myStmt.setString(4, newBusiness.getState().toString());
			myStmt.setString(5, newBusiness.getZip());
			myStmt.setString(6, newBusiness.getPhone());
			myStmt.setString(7, newBusiness.getWebsite());
			myStmt.setInt(8, newBusiness.getRating1());
			myStmt.setInt(9, newBusiness.getRating2());
			myStmt.setInt(10, newBusiness.getRating3());
			myStmt.setInt(11, newBusiness.getRating4());
			myStmt.setInt(12, newBusiness.getRating5());
			
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

	public void update(Business updatedBusiness) 
			throws Exception {
				
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.business "
					+ "SET name=?, address=?, city=?, state=?, zip=?, phone=?, website=?, rating1=rating1+?, rating2=rating2+?, rating3=rating3+?, rating4=rating4+?, rating5=rating5+? "
					+ "WHERE id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setString(1, updatedBusiness.getName());
			myStmt.setString(2, updatedBusiness.getAddress());
			myStmt.setString(3, updatedBusiness.getCity());
			myStmt.setString(4, updatedBusiness.getState().toString());
			myStmt.setString(5, updatedBusiness.getZip());
			myStmt.setString(6, updatedBusiness.getPhone());
			myStmt.setString(7, updatedBusiness.getWebsite());
			myStmt.setInt(8, updatedBusiness.getRating1());
			myStmt.setInt(9, updatedBusiness.getRating2());
			myStmt.setInt(10, updatedBusiness.getRating3());
			myStmt.setInt(11, updatedBusiness.getRating4());
			myStmt.setInt(12, updatedBusiness.getRating5());
			myStmt.setInt(13, updatedBusiness.getId());
			
			// execute SQL UPDATE
			myStmt.execute();

		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public void delete(int id) throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create SQL and PreparedStatement to DELETE business
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
			
			// create SQL and PreparedStatement to SELECT buisness if name matches
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
