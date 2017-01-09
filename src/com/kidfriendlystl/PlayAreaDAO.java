package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class PlayAreaDAO {

	private DataSource dataSource;

	public PlayAreaDAO(DataSource theDataSource) {
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

	public List<PlayArea> getAll() {
		//TODO
		return null;
	}
	
	public PlayArea get(String theBusinessID) {
		//TODO
		return null;
	}
	
	public void add(PlayArea newPlayArea) {
		//TODO
	}
	
	public void update(PlayArea updatedPlayArea) {
		//TODO
	}
}
