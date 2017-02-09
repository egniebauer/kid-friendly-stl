package com.kidfriendlystl;

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
}