package com.ust.user.exception;

public class UserExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public  UserExistsException(String message) {
		super(message);
	}

}
