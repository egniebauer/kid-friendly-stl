package com.kidfriendlystl;

public class RestroomInfo {
	
	private int businessID;
	private boolean clean;
	private boolean toddlerSeat;
	private boolean handDryer;
	private boolean womensRoom;
	private boolean mensRoom;
	private boolean familyRoom;
	private boolean noChangingTable;
	
	public RestroomInfo(int businessID, boolean clean, boolean toddlerSeat, boolean handDryer, boolean womensRoom,
			boolean mensRoom, boolean familyRoom, boolean noChangingTable) {
		this.businessID = businessID;
		this.clean = clean;
		this.toddlerSeat = toddlerSeat;
		this.handDryer = handDryer;
		this.womensRoom = womensRoom;
		this.mensRoom = mensRoom;
		this.familyRoom = familyRoom;
		this.noChangingTable = noChangingTable;
	}

	public RestroomInfo(boolean clean, boolean toddlerSeat, boolean handDryer, boolean womensRoom, boolean mensRoom,
			boolean familyRoom, boolean noChangingTable) {
		this.clean = clean;
		this.toddlerSeat = toddlerSeat;
		this.handDryer = handDryer;
		this.womensRoom = womensRoom;
		this.mensRoom = mensRoom;
		this.familyRoom = familyRoom;
		this.noChangingTable = noChangingTable;
	}

	public int getBusinessID() {
		return businessID;
	}

	public boolean isClean() {
		return clean;
	}

	public boolean isToddlerSeat() {
		return toddlerSeat;
	}

	public boolean isHandDryer() {
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

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public void setToddlerSeat(boolean toddlerSeat) {
		this.toddlerSeat = toddlerSeat;
	}

	public void setHandDryer(boolean handDryer) {
		this.handDryer = handDryer;
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
	
	
}
