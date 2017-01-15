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

	public List<Business> getAll() throws Exception {
		// create empty list
		List<Business> businesses = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.business";
			stmt = conn.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()){
				//retrieve data from ResultSet row
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String city = rs.getString("city");
				State state = State.valueOf(rs.getString("state"));
				String zip = rs.getString("zip");
				String phone = rs.getString("phone");
				String website = rs.getString("website");
				int rating1 = rs.getInt("rating1");
				int rating2 = rs.getInt("rating2");
				int rating3 = rs.getInt("rating3");
				int rating4 = rs.getInt("rating4");
				int rating5 = rs.getInt("rating5");
				
				// format parameters (strip non-digits, leading whitespace, etc.)
				phone = phone != null ? phone.replaceFirst("^1", ""): phone;
				phone = phone != null ? phone.replaceAll("[^\\d]", ""): phone;
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public Business get(String theBusinessID) 
			throws Exception{
		
		// create empty Business and int businessID
		Business theBusiness = null;
		int businessID;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// convert theBusinessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theBusiness
			String sql = "SELECT * FROM kid_friendly_stl.business WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty Business
			if (rs.next()) {
				String name = rs.getString("name"); 
				String address = rs.getString("address"); 
				String city = rs.getString("city"); 
				State state = State.valueOf(rs.getString("state")); 
				String zip = rs.getString("zip");
				String phone = rs.getString("phone"); 
				String website = rs.getString("website");
				int rating1 = rs.getInt("rating1");
				int rating2 = rs.getInt("rating2");
				int rating3 = rs.getInt("rating3");
				int rating4 = rs.getInt("rating4");
				int rating5 = rs.getInt("rating5");
				
				// format parameters (strip non-digits, leading whitespace, etc.)
				phone = phone != null ? phone.replaceFirst("^1\\-", ""): phone;
				phone = phone != null ? phone.replaceAll("[^\\d]", ""): phone;
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public int add(Business newBusiness) 
			throws Exception {
		
		int businessID = 0;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.business "
					+ "(name, address, city, state, zip, phone, website, rating1, rating2, rating3, rating4, rating5) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// set param values
			stmt.setString(1, newBusiness.getName());
			stmt.setString(2, newBusiness.getAddress());
			stmt.setString(3, newBusiness.getCity());
			stmt.setString(4, newBusiness.getState().toString());
			stmt.setString(5, newBusiness.getZip());
			stmt.setString(6, newBusiness.getPhone());
			stmt.setString(7, newBusiness.getWebsite());
			stmt.setInt(8, newBusiness.getRating1());
			stmt.setInt(9, newBusiness.getRating2());
			stmt.setInt(10, newBusiness.getRating3());
			stmt.setInt(11, newBusiness.getRating4());
			stmt.setInt(12, newBusiness.getRating5());
			
			// execute SQL INSERT
			stmt.execute();
			rs = stmt.getGeneratedKeys();

			// create int for business id
			if(rs.next()) {
				   businessID = rs.getInt(1);
				}			
			return businessID;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}

	}

	public void update(Business updatedBusiness) 
			throws Exception {
				
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.business "
					+ "SET name=?, address=?, city=?, state=?, zip=?, phone=?, website=?, rating1=rating1+?, rating2=rating2+?, rating3=rating3+?, rating4=rating4+?, rating5=rating5+? "
					+ "WHERE id=?";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setString(1, updatedBusiness.getName());
			stmt.setString(2, updatedBusiness.getAddress());
			stmt.setString(3, updatedBusiness.getCity());
			stmt.setString(4, updatedBusiness.getState().toString());
			stmt.setString(5, updatedBusiness.getZip());
			stmt.setString(6, updatedBusiness.getPhone());
			stmt.setString(7, updatedBusiness.getWebsite());
			stmt.setInt(8, updatedBusiness.getRating1());
			stmt.setInt(9, updatedBusiness.getRating2());
			stmt.setInt(10, updatedBusiness.getRating3());
			stmt.setInt(11, updatedBusiness.getRating4());
			stmt.setInt(12, updatedBusiness.getRating5());
			stmt.setInt(13, updatedBusiness.getId());
			
			// execute SQL UPDATE
			stmt.execute();

		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
		
	}

	public void delete(int id) throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create SQL and PreparedStatement to DELETE business
			String sql = "DELETE FROM kid_friendly_stl.business WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			// execute SQL statement
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}

	public boolean isDuplicate(String name) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create SQL String and PreparedStatement to SELECT business if name matches
			String sql = "SELECT * FROM kid_friendly_stl.business WHERE name LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			// execute SQL statement
			rs = stmt.executeQuery();
			
			// return boolean
			if (rs.next()){
				return true;
			} else {
				return false;
			}
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public List<Business> getDuplicates(String searchName) throws Exception {
		// create empty list
		List<Business> duplicates = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create SQL String and PreparedStatement to SELECT business if name matches
			String sql = "SELECT * FROM kid_friendly_stl.business WHERE name LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + searchName.substring(0, 3) + "%");
			
			// execute SQL statement
			rs = stmt.executeQuery();
			
			// process result set
			while (rs.next()){
				//retrieve data from ResultSet row
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String city = rs.getString("city");
				State state = State.valueOf(rs.getString("state"));
				String zip = rs.getString("zip");
				String phone = rs.getString("phone");
				String website = rs.getString("website");
				int rating1 = rs.getInt("rating1");
				int rating2 = rs.getInt("rating2");
				int rating3 = rs.getInt("rating3");
				int rating4 = rs.getInt("rating4");
				int rating5 = rs.getInt("rating5");
				
				// create new Business object
				Business currentBusiness = new Business(id, name, address, city, state, zip, 
						phone, website, rating1, rating2, rating3, rating4, rating5);
				
				// add Student object to list
				duplicates.add(currentBusiness);
			}
			// return list
			return duplicates;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

}
