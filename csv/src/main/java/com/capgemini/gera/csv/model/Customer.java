package com.capgemini.gera.csv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.CsvBindByName;

@Entity

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
	
	@CsvBindByName
private String firstName;
	
	@CsvBindByName
private String middleName;
	
	@CsvBindByName
private String lastName;
	
private String email;

@CsvBindByName
private String phoneNo;

@CsvBindByName
private String gender;


@CsvBindByName
private String information;

@CsvBindByName
private String dob;


public Customer() {
	
}

public Customer(long id, String firstName, String middleName, String lastName, String email, String phoneNo,
		String gender, String information, String dob) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNo = phoneNo;
	this.gender = gender;
	this.information = information;
	this.dob = dob;
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

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}


public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getInformation() {
	return information;
}

public void setInformation(String information) {
	this.information = information;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
			+ ", email=" + email + ", phoneNo=" + phoneNo + ", gender=" + gender + ", information=" + information
			+ ", dob=" + dob + "]";
}




}
