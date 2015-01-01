package com.elkammar.thattodo.exceptions;

public class ThatException extends Exception{

	private static final long serialVersionUID = 1890208551436253648L;

	public ThatException(String message) {
		/**
		 * Manage logging service and notification service (internal error notification service)
		 */
		super(message);
	}
}
