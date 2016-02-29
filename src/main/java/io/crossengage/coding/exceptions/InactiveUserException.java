/**
 * 
 */
package io.crossengage.coding.exceptions;

/**
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class InactiveUserException extends Exception {

	/**
	 * 
	 */
	public InactiveUserException() {
	}

	/**
	 * @param message
	 */
	public InactiveUserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InactiveUserException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InactiveUserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InactiveUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
