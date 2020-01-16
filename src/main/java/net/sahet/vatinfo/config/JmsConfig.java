package net.sahet.vatinfo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import lombok.extern.slf4j.Slf4j;

@EnableJms
@Configuration
@Slf4j
public class JmsConfig {

	@Value("${spring.activemq.user}")
	private String user;

	@Value("${spring.activemq.password}")
	private String password;

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		setConnInfo(connectionFactory);

		return connectionFactory;
	}

	private void setConnInfo(ActiveMQConnectionFactory connectionFactory) {
		log.debug("ActiveMQ ---> " + user + ",  " + password + ", " + brokerUrl);
		connectionFactory.setUserName(user);
		connectionFactory.setPassword(password);
		connectionFactory.setBrokerURL(brokerUrl);
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(connectionFactory());
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(cachingConnectionFactory()); // connectionFactory()
		return template;
	}

	/*
	 * @Bean public JmsListenerContainerFactory<?> myFactory(ConnectionFactory
	 * connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
	 * DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory(); configurer.configure(factory,
	 * connectionFactory); return factory; }
	 */

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ActiveMQConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		/**
		 * By default, Spring Boot creates a JmsTemplate configured to transmit to
		 * queues by having pubSubDomain set to false. Below is not help even you set
		 * TRUE, must be done under jmsListenerContainerFactory
		 */
		// factory.setPubSubDomain(true);
		setConnInfo(connectionFactory);
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	/**
	 * Also on the ListenerContainer, we need to indicate if we want to use queues
	 * or topics.
	 * 
	 * @return
	 */
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("1-1");
		factory.setPubSubDomain(true);
		return factory;
	}

}
