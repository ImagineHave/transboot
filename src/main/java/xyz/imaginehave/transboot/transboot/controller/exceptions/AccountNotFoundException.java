package xyz.imaginehave.transboot.transboot.controller.exceptions;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3938424223198488227L;
	
	public AccountNotFoundException(Long id) {
		super("Account doesn't exist for user" + id);
	}

}
