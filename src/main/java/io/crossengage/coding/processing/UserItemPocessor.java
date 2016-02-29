/**
 * 
 */
package io.crossengage.coding.processing;

import io.crossengage.coding.exceptions.InactiveUserException;
import io.crossengage.coding.model.User;

/**
 * process an item to produce another object relative to output for our case it
 * is the same as User
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class UserItemPocessor implements ItemProcessor<User, User> {

	public User processItem(User item) throws InactiveUserException {
		if (item.isActive())
			return item;
		throw new InactiveUserException(String.format("user with email %s is not active", item.getEmail()));
	}
}
