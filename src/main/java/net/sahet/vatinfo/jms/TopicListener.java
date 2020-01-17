package net.sahet.vatinfo.jms;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class TopicListener {

	//Producer and Consumer at the same time 
	@JmsListener(destination = "inbound.topic")
	@SendTo("outbound.topic")
	public String receiveMessageFromTopic(final Message jsonMessage) throws JMSException {

		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		String response = null;
		if (jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessage;
			messageData = textMessage.getText();
			/*
			 * Map map = new Gson().fromJson(messageData, Map.class); response = "Hello " +
			 * map.get("name");
			 */
			
			response = messageData;
			System.out.println("*** TOPIC listened *** message"+response);
		}
		return response;
	}

}
