package net.sahet.vatinfo.config.props;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("spring.activemq")
public class ActiveMqProps {

	@NotNull
	private String user;

	@NotNull
	private String password;

	@NotNull
	private String brokerUrl;
}
