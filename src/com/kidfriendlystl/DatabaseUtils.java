package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Boolean getNull(ResultSet rs, String column) throws SQLException {
		
		Boolean var = rs.getBoolean(column);
		
		if (rs.wasNull()){
			var = null;
		}
		
		return var;
	}


}
