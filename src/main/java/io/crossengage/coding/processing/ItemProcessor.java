/**
 * 
 */
package io.crossengage.coding.processing;

import io.crossengage.coding.exceptions.InactiveUserException;

/**
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public interface ItemProcessor<I, O> {
	/**
	 * This method is responsible for processing of each individual item.
	 * Subclasses should define custom processing logic here.
	 *
	 * @param item
	 *            Item to process
	 * @return result which will be passed to ItemWriter
	 */
	O processItem(I item) throws InactiveUserException;
}
