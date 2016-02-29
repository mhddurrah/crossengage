/**
 * 
 */
package io.crossengage.coding.model;

import java.io.Serializable;

import io.crossengage.coding.exceptions.UserSyntaxException;
import io.crossengage.coding.service.EmailRecipient;

/**
 * user date model
 * 
 * @author mohamd dorra
 */
public class User implements Serializable, EmailRecipient {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9014896472010254269L;

	private final String firstName;
	private final String lastName;
	private final String email;
	private final boolean isActive;

	public User(String email, String firstName, String lastName, boolean isActive) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public boolean isActive() {
		return isActive;
	}

	/**
	 * create a member from a string input
	 * 
	 * @param line
	 * @return
	 * @throws Exception
	 *             either {@link UserSyntaxException} or
	 *             {@link NumberFormatException}
	 */
	public static User fromString(String line) throws Exception {
		String[] items = line.split(",");
		if (items.length < 4)
			throw new UserSyntaxException();
		String email = items[0].trim();
		String firstName = items[1].trim();
		String lastName = items[2].trim();
		boolean isActive = items[3].equalsIgnoreCase("true");
		return new User(email, firstName, lastName, isActive);
	}

	/**
	 * indicate that the input data read finished
	 * 
	 * @author durrah
	 *
	 */
	public static class NullUser extends User {

		public NullUser(String firstName, String lastName, String email, boolean isActive) {
			super(firstName, lastName, email, isActive);
		}
	}

}
