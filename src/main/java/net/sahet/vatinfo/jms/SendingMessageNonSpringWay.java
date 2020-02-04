package net.sahet.vatinfo.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class SendingMessageNonSpringWay {
	public static void main(String[] args) {
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

		try (Connection conn = cf.createConnection();
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
			Destination destination = new ActiveMQQueue("from-non-spring-way-spitter.queue");
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			message.setText("Berekella !!!@, sending message to Queue via Non-Spring way!");
			producer.send(message);
		} catch (JMSException e) {
			System.err.println("JMS error: " + e.getMessage());
		}
	}

}
