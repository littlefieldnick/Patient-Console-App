package edu.usm.cos420.domain;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable{
	long id;
	String firstName;
	String lastName;
	String gender; 
	String address;
	Date birthDate;
	
	public Patient() {
		//Empty Constructor
	}
	
	public Patient(int id, String fName, String lName, String address, String gender, Date dob) {
		this.id = id;
		this.firstName = fName;
		this.lastName = lName;
		this.address = address;
		this.gender = gender;
		this.birthDate = dob;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBasicInfo() {
		return this.getId() + "\t" + this.getFirstName() + " " + this.getLastName();
	}
	
	public String toString() {
		return "Id: " + this.id + 
				"\nFull Name: " + this.firstName + " " + this.lastName + 
				"\nAddress: " + this.address +
				"\nGender: " + this.gender +
				"\nDOB: " + this.birthDate;
		
	}
}