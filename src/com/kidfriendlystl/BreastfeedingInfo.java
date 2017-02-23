package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class BreastfeedingInfo {
	
	private int businessID;
	private Boolean clean;
	private Boolean comfortable;
	private Boolean bottleWarmer;
	private boolean lactationRoom;
	private boolean quietArea;
	private boolean grossOpts;
	private boolean nonSpecificOpts;
	
	public BreastfeedingInfo(int businessID, Boolean clean, Boolean comfortable, Boolean bottleWarmer,
			boolean lactationRoom, boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this(clean, comfortable, bottleWarmer, lactationRoom, quietArea, grossOpts, nonSpecificOpts);
		this.businessID = businessID;
	}

	public BreastfeedingInfo(int businessID, boolean clean, boolean comfortable, boolean bottleWarmer,
			boolean lactationRoom, boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this(clean, comfortable, bottleWarmer, lactationRoom, quietArea, grossOpts, nonSpecificOpts);
		this.businessID = businessID;
	}

	public BreastfeedingInfo(Boolean clean, Boolean comfortable, Boolean bottleWarmer, boolean lactationRoom,
			boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.clean = clean;
		this.comfortable = comfortable;
		this.bottleWarmer = bottleWarmer;
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}
	
	public BreastfeedingInfo(boolean clean, boolean comfortable, boolean bottleWarmer, boolean lactationRoom,
			boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.clean = new Boolean(clean);
		this.comfortable = new Boolean(comfortable);
		this.bottleWarmer = new Boolean(bottleWarmer);
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}

	public int getBusinessID() {
		return businessID;
	}

	public Boolean getClean() {
		return clean;
	}

	public Boolean getComfortable() {
		return comfortable;
	}

	public Boolean getBottleWarmer() {
		return bottleWarmer;
	}

	public boolean isLactationRoom() {
		return lactationRoom;
	}

	public boolean isQuietArea() {
		return quietArea;
	}

	public boolean isGrossOpts() {
		return grossOpts;
	}

	public boolean isNonSpecificOpts() {
		return nonSpecificOpts;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setClean(boolean clean) {
		this.clean = Boolean.valueOf(clean);
	}
	public void setClean(Boolean clean) {
		this.clean = clean;
	}

	public void setComfortable(boolean comfortable) {
		this.comfortable = Boolean.valueOf(comfortable);
	}
	public void setComfortable(Boolean comfortable) {
		this.comfortable = comfortable;
	}

	public void setBottleWarmer(boolean bottleWarmer) {
		this.bottleWarmer = Boolean.valueOf(bottleWarmer);
	}
	public void setBottleWarmer(Boolean bottleWarmer) {
		this.bottleWarmer = bottleWarmer;
	}

	public void setLactationRoom(boolean lactationRoom) {
		this.lactationRoom = lactationRoom;
	}

	public void setQuietArea(boolean quietArea) {
		this.quietArea = quietArea;
	}

	public void setGrossOpts(boolean grossOpts) {
		this.grossOpts = grossOpts;
	}

	public void setNonSpecificOpts(boolean nonSpecificOpts) {
		this.nonSpecificOpts = nonSpecificOpts;
	}

	public static BreastfeedingInfo createBreastfeeding(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty Category object
		BreastfeedingInfo newBreastfeedingInfo;
				
		// retrieve form data		
		String breastfeedingCleanRadio = request.getParameter("breastfeedingClean");
		String comfortableRadio = request.getParameter("comfortable");
		String bottleWarmerRadio = request.getParameter("bottleWarmer");
		String[] breastfeedingLocations = request.getParameterValues("poppingBoobs"); 
	
		// assign data to parameters
		Boolean clean = null;
		if (breastfeedingCleanRadio != null) {
			clean = breastfeedingCleanRadio.equals("1") ? true : false;
		}
		Boolean comfortable = null;
		if (comfortableRadio != null) {
			comfortable = comfortableRadio.equals("1") ? true : false;
		}
		Boolean bottleWarmer = null;
		if (bottleWarmerRadio != null) {
			bottleWarmer = bottleWarmerRadio.equals("1") ? true : false;
		}
		
		boolean lactationRoom = false;
		boolean quietArea = false;
		boolean grossOpts = false;
		boolean nonSpecificOpts = false;
		if (breastfeedingLocations != null) {
			for (String location : breastfeedingLocations) {
				switch (location) {
					case "lactationRoom":
						lactationRoom = true;
						break;
					case "quietArea":
						quietArea = true;
						break;
					case "grossOpts":
						grossOpts = true;
						break;
					case "nonSpecificOpts":
						nonSpecificOpts = true;
						break;
				}
			}
		}
		
		// pass parameters to object and return
		newBreastfeedingInfo = new BreastfeedingInfo (businessID, clean, comfortable, bottleWarmer, lactationRoom, quietArea, grossOpts, nonSpecificOpts);
		return newBreastfeedingInfo;
	}

}
