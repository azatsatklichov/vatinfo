package net.sahet.vatinfo.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

	/**
	 * Spring’s JmsTemplate can receive messages directly through its receive
	 * method, but that only works synchronously, meaning it will block. That’s why
	 * we recommend that you use a listener container such as
	 * DefaultMessageListenerContainer with a cache-based connection factory, so you
	 * can consume messages asynchronously and with maximum connection efficiency.
	 * 
	 * The @JmsListener annotation creates a message listener container for the
	 * annotated receive() method.
	 * 
	 * @param jsonMessage
	 * @return
	 * @throws JMSException
	 */
	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(final Message jsonMessage) throws JMSException {

		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		String response = null;
		if (jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessage;
			messageData = textMessage.getText();
			/*
			 * Map map = new Gson().fromJson(messageData, Map.class); response =
			 * "---> Hello " + map.get("name");
			 */

			response = messageData;
			System.out.println("### QUEUE listened ###  message" + response);
		}
		return response;

	}

}
