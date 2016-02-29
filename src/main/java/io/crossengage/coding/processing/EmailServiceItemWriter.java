package io.crossengage.coding.processing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;

import io.crossengage.coding.model.User;
import io.crossengage.coding.service.EmailService;

/**
 * an implementation of {@link ItemWriter} that uses a {@link BlockingQueue} to
 * achieve chunk functionality
 * 
 * @author mohamd dorra (mhd.durrah@gmail.com)
 *
 */
public class EmailServiceItemWriter implements ItemWriter<User> {
	private BlockingQueue<User> batchQueue;
	private EmailService emailService;

	public EmailServiceItemWriter(BlockingQueue<User> batchQueue, EmailService emailService) {
		this.batchQueue = batchQueue;
		this.emailService = emailService;
	}

	public void write(User item) {
		batchQueue.add(item);
	}

	public boolean shouldFlush() {
		return batchQueue.size() == 10;
	}

	public void flush() {
		Collection<User> recipients = new ArrayList<User>();
		batchQueue.drainTo(recipients);
		emailService.batchSendEmail(recipients);
	}
}
