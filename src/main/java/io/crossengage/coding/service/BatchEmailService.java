/**
 * 
 */
package io.crossengage.coding.service;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * @author kancy
 *
 */
public class BatchEmailService implements EmailService {

	private final Logger logger = Logger.getLogger(BatchEmailService.class.getName());

	public void sendEmail(EmailRecipient recipient) {
		throw new UnsupportedOperationException("sending single email not supported");
	}

	public void batchSendEmail(Collection<? extends EmailRecipient> recipients) {
		for (EmailRecipient recipient : recipients) {
			logger.info(String.format("Sending email to: %s", recipient.getEmail()));
		}
	}

}
