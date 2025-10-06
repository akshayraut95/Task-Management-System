package com.ex.Exception;

public class UserNotFoundException extends Exception {

	 public UserNotFoundException() {
	        super("User with this username not found in database !!");
	    }

	    public UserNotFoundException(String msg) {
	        super(msg);
	    }
	}

