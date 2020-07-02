package com.lockedMeApp.modal;

public class Files {
	
	private String fname;

	
	public Files(String fname) {
		super();
		this.fname = fname;
	}


	public Files() {
		// TODO Auto-generated constructor stub
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	@Override
	public String toString() {
		return "Files [fname=" + fname + "]";
	}
	
	

}
