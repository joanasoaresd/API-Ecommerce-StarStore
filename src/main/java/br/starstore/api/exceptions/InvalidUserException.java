package br.starstore.api.exceptions;

public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public InvalidUserException () {
		super("Invalid user fields");
	}
	
	public InvalidUserException (String msg) {
		super(msg);
	}
}
