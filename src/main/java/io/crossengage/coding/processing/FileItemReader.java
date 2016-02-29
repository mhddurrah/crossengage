/**
 * 
 */
package io.crossengage.coding.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import io.crossengage.coding.exceptions.ItemReadException;
import io.crossengage.coding.model.User;

/**
 * read user information from a flat file line by line
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class FileItemReader implements ItemReader<User> {
	private BufferedReader reader;

	public FileItemReader(String filePath) throws IOException {
		reader = new BufferedReader(new FileReader(filePath));
	}

	public FileItemReader(Reader reader) throws IOException {
		this.reader = new BufferedReader(reader);
	}

	public User readItem() throws ItemReadException {
		try {
			String line = reader.readLine();
			if (line == null) {
				reader.close();
				return new User.NullUser("", "", "", false);
			}
			return User.fromString(line);
		} catch (Exception e) {
			throw new ItemReadException(e);
		}
	}
}