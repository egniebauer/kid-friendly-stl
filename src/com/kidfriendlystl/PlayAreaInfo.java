package com.kidfriendlystl;

public class PlayAreaInfo {
	
	private int businessID;
	private Boolean clean;
	private boolean inside;
	private boolean outside;
	private Boolean gated;
	private Boolean fun;
	
	public PlayAreaInfo(int businessID, Boolean clean, boolean inside, boolean outside, Boolean gated, Boolean fun) {
		this(clean, inside, outside, gated, fun);
		this.businessID = businessID;
		this.fun = fun;
	}

	public PlayAreaInfo(Boolean clean, boolean inside, boolean outside, Boolean gated, Boolean fun) {
		this.clean = clean;
		this.inside = inside;
		this.outside = outside;
		this.gated = gated;
		this.fun = fun;
	}

	public PlayAreaInfo(int businessID, boolean clean, boolean inside, boolean outside, boolean gated, boolean fun) {
		this(clean, inside, outside, gated, fun);
		this.businessID = businessID;
	}

	public PlayAreaInfo(boolean clean, boolean inside, boolean outside, boolean gated, boolean fun) {
		this.clean = new Boolean(clean);
		this.inside = inside;
		this.outside = outside;
		this.gated = new Boolean(gated);
		this.fun = new Boolean(fun);
	}

	public int getBusinessID() {
		return businessID;
	}

	public Boolean getClean() {
		return clean;
	}

	public boolean isInside() {
		return inside;
	}

	public boolean isOutside() {
		return outside;
	}

	public Boolean getGated() {
		return gated;
	}

	public Boolean getFun() {
		return fun;
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

	public void setInside(boolean inside) {
		this.inside = inside;
	}

	public void setOutside(boolean outside) {
		this.outside = outside;
	}

	public void setGated(boolean gated) {
		this.gated = Boolean.valueOf(gated);
	}
	public void setGated(Boolean gated) {
		this.gated = gated;
	}

	public void setFun(boolean fun) {
		this.fun = Boolean.valueOf(fun);
		}
	public void setFun(Boolean fun) {
		this.fun = fun;
	}

}
