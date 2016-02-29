/**
 * 
 */
package io.crossengage.coding.exceptions;

/**
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class UserSyntaxException extends Exception {

	/**
	 * 
	 */
	public UserSyntaxException() {
	}

	/**
	 * @param message
	 */
	public UserSyntaxException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UserSyntaxException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserSyntaxException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UserSyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
