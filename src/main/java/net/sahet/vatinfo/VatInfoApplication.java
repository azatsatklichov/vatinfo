package net.sahet.vatinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Azat Satklichov
 */
@SpringBootApplication
@EnableSwagger2 // @EnableSwagger2WebMvc
public class VatInfoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VatInfoApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		System.out.println("Sending an email message.");
		// jmsTemplate.convertAndSend("mailbox", new Email("azatas@seznam.cz", "Ymyt,
		// Zahmet, Niyet, Towekgel"));
		
		//QUEUE
		//jmsTemplate.convertAndSend("inbound.queue", "Ymyt, Zahmet, Niyet, Towekgel");


		//TOPIC
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.convertAndSend("inbound.topic", "TOPIC: Ymyt, Zahmet, Niyet, Towekgel");
	}
}
