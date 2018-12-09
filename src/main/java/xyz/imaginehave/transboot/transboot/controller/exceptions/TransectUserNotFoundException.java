package xyz.imaginehave.transboot.transboot.controller.exceptions;

public class TransectUserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3938424223198488227L;
	
	public TransectUserNotFoundException(Long id) {
		super("User doesn't exist" + id);
	}

}
