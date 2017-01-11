package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class PlayAreaInfoDAO {

	private DataSource dataSource;

	public PlayAreaInfoDAO(DataSource theDataSource) {
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

	public List<PlayAreaInfo> getAll() {
		//TODO
		return null;
	}
	
	public PlayAreaInfo get(String theBusinessID) {
		//TODO
		return null;
	}
	
	public void add(PlayAreaInfo newPlayAreaInfo) {
		//TODO
	}
	
	public void update(PlayAreaInfo updatedPlayAreaInfo) {
		//TODO
	}
}
