package io.crossengage.coding;

import java.io.IOException;
import java.io.StringReader;

import io.crossengage.coding.exceptions.ItemReadException;
import io.crossengage.coding.model.User;
import io.crossengage.coding.processing.FileItemReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class UserReaderTest {
	/*
	 * @throws IOException
	 * 
	 * @throws ItemReadException
	 */
	@Test
	public void testUserNotNull() throws IOException, ItemReadException {
		StringReader reader = new StringReader("mhd.durrah@gmail.com,Muhammad,Durrah,false");
		FileItemReader fileItemReader = new FileItemReader(reader);
		User user = fileItemReader.readItem();
		assertNotNull(user);
	}

	/**
	 * 
	 * @throws IOException
	 * @throws ItemReadException
	 */
	@Test
	public void testUserEmail() throws IOException, ItemReadException {
		StringReader reader = new StringReader("mhd.durrah@gmail.com,Muhammad,Durrah,false");
		FileItemReader fileItemReader = new FileItemReader(reader);
		User user = fileItemReader.readItem();
		assertNotNull(user);
		assertEquals(user.getEmail(), "mhd.durrah@gmail.com");
	}

	/**
	 * 
	 * @throws IOException
	 * @throws ItemReadException
	 */
	@Test
	public void testUserActive() throws IOException, ItemReadException {
		StringReader reader = new StringReader("mhd.durrah@gmail.com,Muhammad,Durrah,false");
		FileItemReader fileItemReader = new FileItemReader(reader);
		User user = fileItemReader.readItem();
		assertNotNull(user);
		assertFalse(user.isActive());
	}

	@Test(expected = ItemReadException.class)
	public void testException() throws IOException, ItemReadException {
		StringReader reader = new StringReader("Muhammad,Durrah,false");
		FileItemReader fileItemReader = new FileItemReader(reader);
		User user = fileItemReader.readItem();
	}
}