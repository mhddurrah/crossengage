/**
* 
*/
package io.crossengage.coding.processing;

/**
 * Writes result of the processing performed by ItemProcessing.
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public interface ItemWriter<O> {

	/**
	 * Writes an item produced by ItemProcessing (see 'O process(I item)'
	 * method). This could imply writing into a database or a file or an email
	 * provider, depending on the implementation.
	 */
	void write(O item);

	/**
	 * should we flush the batch
	 * 
	 * @return
	 */
	boolean shouldFlush();

	/**
	 * flushing the batch chunk
	 */
	void flush();
}
