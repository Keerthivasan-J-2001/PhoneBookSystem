package com.training.exception;

public class EmailException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public EmailException(String errMsg){
		super(errMsg);
	}
}
