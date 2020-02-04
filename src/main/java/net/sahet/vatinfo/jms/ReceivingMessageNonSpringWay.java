package net.sahet.vatinfo.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ReceivingMessageNonSpringWay {
	public static void main(String[] args) {
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

		try (Connection conn = cf.createConnection();
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
			conn.start();
			Destination destination = new ActiveMQQueue("from-non-spring-way-spitter.queue");
			MessageConsumer consumer = session.createConsumer(destination);
			Message message = consumer.receive();
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Received Messaege  ===> : \n " + textMessage);
			conn.start();
		} catch (JMSException e) {
			System.err.println("JMS error: " + e.getMessage());
		}
	}

}
