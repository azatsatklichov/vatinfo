package net.sahet.vatinfo.jms;

import java.util.concurrent.atomic.AtomicReference;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Sender {

	@Autowired
	private Destination statusDestination;

	@Autowired
	private JmsTemplate jmsTemplate;

	public String sendOrder(String orderNumber) throws JMSException {
		final AtomicReference<Message> message = new AtomicReference<>();

		jmsTemplate.convertAndSend(orderNumber, messagePostProcessor -> {
			message.set(messagePostProcessor);
			return messagePostProcessor;
		});

		String messageId = message.get().getJMSMessageID();
		log.info("sending OrderNumber='{}' with MessageId='{}'", orderNumber, messageId);

		return messageId;
	}

	public String receiveOrderStatus(String correlationId) {
		String status = (String) jmsTemplate.receiveSelectedAndConvert(statusDestination,
				"JMSCorrelationID = '" + correlationId + "'");
		log.info("receive Status='{}' for CorrelationId='{}'", status, correlationId);

		return status;
	}

	public void send(String destination, String message) {
		log.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, message);
	}
}
