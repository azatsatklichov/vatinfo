package net.sahet.vatinfo.jms;

import java.util.concurrent.CountDownLatch;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Receiver {

	@Autowired
	private Destination statusDestination;

	@Autowired
	private JmsTemplate jmsTemplate;

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@JmsListener(destination = "destination.order")
	public void receiveOrder(String orderNumber, @Header(JmsHeaders.MESSAGE_ID) String messageId) {
		log.info("received OrderNumber='{}' with MessageId='{}'", orderNumber, messageId);

		log.info("sending Status='Accepted' with CorrelationId='{}'", messageId);

		jmsTemplate.send(statusDestination, messageCreator -> {
			TextMessage message = messageCreator.createTextMessage("Accepted");
			message.setJMSCorrelationID(messageId);
			return message;
		});
	}

	@JmsListener(destination = "inbound.topic")
	public void receive(String message) {
		log.info("received message='{}'", message);
		latch.countDown();
	}
}
