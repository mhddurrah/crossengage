/**
 * 
 */
package io.crossengage.coding.exceptions;

/**
 * indicates an error in reading item from source
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class ItemReadException extends Exception {

	/**
	 * 
	 */
	public ItemReadException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ItemReadException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ItemReadException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ItemReadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ItemReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
