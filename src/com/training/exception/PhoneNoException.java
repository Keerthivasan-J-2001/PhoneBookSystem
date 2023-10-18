package com.training.exception;

public class PhoneNoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PhoneNoException(String errMsg){
		super(errMsg);
	}
}
