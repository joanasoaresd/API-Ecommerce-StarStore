package br.starstore.api.exceptions;

public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(){
		super("User already exists");
	}
	
	UserAlreadyExistsException(String msg){
		super(msg);
	}
}
