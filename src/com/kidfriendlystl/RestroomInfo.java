package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class RestroomInfo {
	
	private int businessID;
	private Boolean clean;
	private Boolean toddlerSeat;
	private Boolean handDryer;
	private boolean womensRoom;
	private boolean mensRoom;
	private boolean familyRoom;
	private boolean noChangingTable;
	
	public RestroomInfo(int businessID, Boolean clean, Boolean toddlerSeat, Boolean handDryer, boolean womensRoom,
			boolean mensRoom, boolean familyRoom, boolean noChangingTable) {
		this(clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
		this.businessID = businessID;
	}

	public RestroomInfo(Boolean clean, Boolean toddlerSeat, Boolean handDryer, boolean womensRoom, boolean mensRoom,
			boolean familyRoom, boolean noChangingTable) {
		this.clean = clean;
		this.toddlerSeat = toddlerSeat;
		this.handDryer = handDryer;
		this.womensRoom = womensRoom;
		this.mensRoom = mensRoom;
		this.familyRoom = familyRoom;
		this.noChangingTable = noChangingTable;
	}
	
	public RestroomInfo(int businessID, boolean clean, boolean toddlerSeat, boolean handDryer, boolean womensRoom,
			boolean mensRoom, boolean familyRoom, boolean noChangingTable) {
		this(clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
		this.businessID = businessID;
	}

	public RestroomInfo(boolean clean, boolean toddlerSeat, boolean handDryer, boolean womensRoom, boolean mensRoom,
			boolean familyRoom, boolean noChangingTable) {
		this.clean = new Boolean(clean);
		this.toddlerSeat = new Boolean(toddlerSeat);
		this.handDryer = new Boolean(handDryer);
		this.womensRoom = womensRoom;
		this.mensRoom = mensRoom;
		this.familyRoom = familyRoom;
		this.noChangingTable = noChangingTable;
	}

	public int getBusinessID() {
		return businessID;
	}

	public Boolean getClean() {
		return clean;
	}

	public Boolean getToddlerSeat() {
		return toddlerSeat;
	}

	public Boolean getHandDryer() {
		return handDryer;
	}

	public boolean isWomensRoom() {
		return womensRoom;
	}

	public boolean isMensRoom() {
		return mensRoom;
	}

	public boolean isFamilyRoom() {
		return familyRoom;
	}

	public boolean isNoChangingTable() {
		return noChangingTable;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setClean(Boolean clean) {
		this.clean = clean;
	}
	public void setClean(boolean clean) {
		this.clean = Boolean.valueOf(clean);
	}

	public void setToddlerSeat(Boolean toddlerSeat) {
		this.toddlerSeat = toddlerSeat;
	}
	public void setToddlerSeat(boolean toddlerSeat) {
		this.toddlerSeat = Boolean.valueOf(toddlerSeat);
	}

	public void setHandDryer(Boolean handDryer) {
		this.handDryer = handDryer;
	}
	public void setHandDryer(boolean handDryer) {
		this.handDryer = Boolean.valueOf(handDryer);
	}

	public void setWomensRoom(boolean womensRoom) {
		this.womensRoom = womensRoom;
	}

	public void setMensRoom(boolean mensRoom) {
		this.mensRoom = mensRoom;
	}

	public void setFamilyRoom(boolean familyRoom) {
		this.familyRoom = familyRoom;
	}

	public void setNoChangingTable(boolean noChangingTable) {
		this.noChangingTable = noChangingTable;
	}

	public static RestroomInfo createRestroomEntry(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		RestroomInfo newRestroomInfo;
		
		// retrieve data
		String restroomCleanRadio = request.getParameter("restroomClean");
		String toddlerSeatRadio = request.getParameter("toddlerSeat");
		String handDryerRadio = request.getParameter("handDryer");
		String[] changingTables = request.getParameterValues("changingTable");
		
		// set data to params
		Boolean clean = null;
		if (restroomCleanRadio != null) {
			clean = restroomCleanRadio.equals("1") ? true : false;
		}
		Boolean toddlerSeat = null;
		if (toddlerSeatRadio != null) {
			toddlerSeat = toddlerSeatRadio.equals("1") ? true : false;
		}
		Boolean handDryer = null;
		if (handDryerRadio != null) {
			handDryer = handDryerRadio.equals("1") ? true : false;
		}
	
		boolean womensRoom = false;
		boolean mensRoom = false;
		boolean familyRoom = false;
		boolean noChangingTable = false;
		if (changingTables != null){
			for (String table : changingTables) {
				switch (table){
					case "womensRoom" :
						womensRoom = true;
						break;
					case "mensRoom" :
						mensRoom = true;
						break;
					case "familyRoom" :
						familyRoom = true;
						break;
					case "noChangingTable" :
						noChangingTable = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newRestroomInfo = new RestroomInfo(businessID, clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
		return newRestroomInfo;
	}
	
	
}
