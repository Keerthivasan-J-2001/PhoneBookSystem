package com.training.modal;

import java.util.Objects;

import com.training.exception.EmailException;
import com.training.exception.PhoneNoException;
import com.training.service.Validation;

public class PhoneBook implements Comparable<PhoneBook> {
	private String contactName;
	private String phoneNo;
	private String email;
	private String address;
	
	public PhoneBook(String contactName, String phoneNo, String email, String address)
			throws PhoneNoException,EmailException {
		this.contactName = contactName;
		if(Validation.phNoVal(phoneNo))
			this.phoneNo = phoneNo;
		else
			throw new PhoneNoException("Invalid Phone number!!(PhoneNoException)");
		
		if(Validation.emailVal(email))
			this.email = email;
		else
			throw new EmailException("Invalid Email!!(EmailException)");
		
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PhoneBook [contactName="+this.contactName + ", phoneNo=" + this.phoneNo 
				+ ", email=" + this.email + ", address="+ this.address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactName);
	}
	
	@Override
	public int compareTo(PhoneBook o) {
		return this.contactName.compareTo(o.contactName);
	}
	
}