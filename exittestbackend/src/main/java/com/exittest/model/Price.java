package com.exittest.model;

public class Price {
	
	float range1;
	float range2;

	public float getRange1() {
		return range1;
	}

	public void setRange1(float range1) {
		this.range1 = range1;
	}

	public float getRange2() {
		return range2;
	}

	public void setRange2(float range2) {
		this.range2 = range2;
	}

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Price [range1=" + range1 + ", range2=" + range2 + "]";
	}

}
