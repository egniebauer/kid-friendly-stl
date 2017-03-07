package com.kidfriendlystl;

public class User {
	
	private int userID;
	private boolean administrator;
	private String email;
	private String password;
	
	public User(int userID, boolean administrator, String email, String password) {
		this(administrator, email, password);
		this.userID = userID;
	}
	
	public User(boolean administrator, String email, String password) {
		this.administrator = administrator;
		this.email = email;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setAdministrator(boolean adminstrator) {
		this.administrator = adminstrator;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
