package org.kamil.messenger.exception;

public class DataNotFoundException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2245494262307373449L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
