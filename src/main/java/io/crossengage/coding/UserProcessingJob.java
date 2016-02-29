package io.crossengage.coding;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import io.crossengage.coding.exceptions.ItemReadException;
import io.crossengage.coding.exceptions.InactiveUserException;
import io.crossengage.coding.model.User;
import io.crossengage.coding.processing.EmailServiceItemWriter;
import io.crossengage.coding.processing.FileItemReader;
import io.crossengage.coding.processing.ItemProcessor;
import io.crossengage.coding.processing.ItemReader;
import io.crossengage.coding.processing.ItemWriter;
import io.crossengage.coding.processing.UserItemPocessor;
import io.crossengage.coding.service.BatchEmailService;
import io.crossengage.coding.service.EmailService;

/**
 * Main Job processor
 * 
 * @author kancy
 *
 */
public class UserProcessingJob {
	private final static Logger logger = Logger.getLogger(UserProcessingJob.class.getName());

	private ItemReader<User> reader;
	private ItemWriter<User> writer;
	private ItemProcessor<User, User> processor;
	private BlockingQueue<User> batchQueue;
	private EmailService emailService;

	public UserProcessingJob() throws IOException {
		emailService = new BatchEmailService();
		batchQueue = new LinkedBlockingQueue<User>();

		reader = new FileItemReader("/home/kancy/crossengage/users.data");
		writer = new EmailServiceItemWriter(batchQueue, emailService);
		processor = new UserItemPocessor();
	}

	public static void main(String[] args) {
		UserProcessingJob job;
		try {
			job = new UserProcessingJob();
			job.start();
		} catch (IOException e) {
			logger.severe(String.format("error with data file: %s", e.getMessage()));
		}
	}

	private void start() {
		User user = null;
		while (true) {
			try {
				user = reader.readItem();
				if (user instanceof User.NullUser) {
					writer.flush();
					break;
				} else {
					User out = processor.processItem(user);
					writer.write(out);
					if (writer.shouldFlush())
						writer.flush();
				}
			} catch (ItemReadException | InactiveUserException e) {
				logger.severe(String.format(e.getMessage()));
			}
		}
	}

}
