/**
 * 
 */
package io.crossengage.coding.processing;

import io.crossengage.coding.exceptions.ItemReadException;

/**
 * Provides items to ItemProcessing independently of the source they are taken
 * from.
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public interface ItemReader<I> {
	/**
	 * Retrieves <b>next</b> item which can be processed by ItemProcesser. When
	 * there are no more new items it will return null.
	 */
	I readItem() throws ItemReadException;
}
