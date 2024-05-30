package com.funfit.bean;

public class Participants {
	//Attributes
	private int partId;
	private String fname;
	private String lname;
	private int age;
	private String phoneNumer;
	private int batchId;
	
	//Constructors
	public Participants(int partId, String fname, String lname, int age, String phoneNumer, int batchId) {
		super();
		this.partId = partId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.phoneNumer = phoneNumer;
		this.batchId = batchId;
	}
	public Participants() {
		super();
	}
	
	//Getter and Setter Methods
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumer() {
		return phoneNumer;
	}
	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	
	//Override toString Method
	@Override
	public String toString() {
		return "Participants [partId=" + partId + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", phone="
				+ phoneNumer + ", batchId=" + batchId + "]";
	}
	
}
