/**
 * 
 */
package io.crossengage.coding.service;

import java.util.Collection;

/**
 * @author mohamd dorra
 *
 */
public interface EmailService {
	void sendEmail(EmailRecipient recipient);

	void batchSendEmail(Collection<? extends EmailRecipient> recipients);
}
