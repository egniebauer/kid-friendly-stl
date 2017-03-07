package com.kidfriendlystl;

import java.util.ArrayList;

public class User {
	
	private int userID;
	private boolean administrator;
	private String email;
	private String password;
	private ArrayList<Integer> favorites;
	
	public User(int userID, boolean administrator, String email, String password, ArrayList<Integer> favorites) {
		this(administrator, email, password, favorites);
		this.userID = userID;
	}
	
	public User(boolean administrator, String email, String password, ArrayList<Integer> favorites) {
		this.administrator = administrator;
		this.email = email;
		this.password = password;
		this.favorites = new ArrayList<Integer>(favorites);
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

	public ArrayList<?> getFavorites() {
		return favorites;
	}

	public void setFavorites(ArrayList<Integer> favorites) {
		this.favorites = new ArrayList<Integer>(favorites);
	}
}
