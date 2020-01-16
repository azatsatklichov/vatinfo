package net.sahet.vatinfo.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

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
			System.out.println("### JMS ### Getting ActiveMQ message"+response);
		}
		return response;

	}

}
