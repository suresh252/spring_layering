package com.naukri.pojos;

public class Student {
	
	//@GeneratedValue(strategy=GenerationType.AUTO) // for auto increment
	private int stdId;
	
	private String name;
	
	private String college;

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	
	
}
