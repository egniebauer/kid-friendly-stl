package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class AgeRange {
	
	private int businessID;
	private boolean baby;
	private boolean toddler;
	private boolean preschooler;
	private boolean gradeSchooler;
	private boolean teen;
	
	public AgeRange(int businessID, boolean baby, boolean toddler, boolean preschooler,
			boolean gradeSchooler, boolean teen) {
		this(baby, toddler, preschooler, gradeSchooler, teen);
		this.businessID = businessID;
	}
	
	public AgeRange(boolean baby, boolean toddler, boolean preschooler,
			boolean gradeSchooler, boolean teen) {
		this.baby = baby;
		this.toddler = toddler;
		this.preschooler = preschooler;
		this.gradeSchooler = gradeSchooler;
		this.teen = teen;
	}

	public int getBusinessID() {
		return businessID;
	}

	public boolean isBaby() {
		return baby;
	}

	public boolean isToddler() {
		return toddler;
	}

	public boolean isPreschooler() {
		return preschooler;
	}

	public boolean isGradeSchooler() {
		return gradeSchooler;
	}

	public boolean isTeen() {
		return teen;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setBaby(boolean baby) {
		this.baby = baby;
	}

	public void setToddler(boolean toddler) {
		this.toddler = toddler;
	}

	public void setPreschooler(boolean preschooler) {
		this.preschooler = preschooler;
	}

	public void setGradeSchooler(boolean gradeSchooler) {
		this.gradeSchooler = gradeSchooler;
	}

	public void setTeen(boolean teen) {
		this.teen = teen;
	}

	public static AgeRange createAgeRange(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty AgeRange object
		AgeRange newAgeRange;
		
		// retrieve data from the form
		String[] ages = request.getParameterValues("ageRange");
		
		//set params
		boolean baby = false;
		boolean toddler = false;
		boolean preschooler = false;
		boolean gradeSchooler = false;
		boolean teen = false;
	
		if (ages != null){
			for (String age: ages){
				switch (age) {
					case "baby":
						baby = true;
						break;
					case "toddler":
						toddler = true;
						break;
					case "preschooler":
						preschooler = true;
						break;
					case "gradeSchooler":
						gradeSchooler = true;
						break;
					case "teen":
						teen = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newAgeRange = new AgeRange(businessID, baby, toddler, preschooler, gradeSchooler, teen);
		return newAgeRange;
	}
}