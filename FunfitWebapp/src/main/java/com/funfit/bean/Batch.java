package com.funfit.bean;

public class Batch {
	//Attributes
	private int batchId;
	private String typeOfBatch;
	private String time;
	
	//Constructors
	public Batch(int batchId, String typeOfBatch, String time) {
		super();
		this.batchId = batchId;
		this.typeOfBatch = typeOfBatch;
		this.time = time;
	}
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getter and Setter Methods
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getTypeOfBatch() {
		return typeOfBatch;
	}
	public void setTypeOfBatch(String typeOfBatch) {
		this.typeOfBatch = typeOfBatch;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	//Override toString Method
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", typeOfBatch=" + typeOfBatch + ", time=" + time + "]";
	}
	
	
}
