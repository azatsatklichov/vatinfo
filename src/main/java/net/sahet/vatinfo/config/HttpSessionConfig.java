package net.sahet.vatinfo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpSessionConfig {

	/**
	 * Spring Session provides an API and implementations for managing a user’s
	 * session information. Spring Session provides transparent integration with
	 * HttpSession. This means that developers can switch the HttpSession
	 * implementation out with an implementation that is backed by Spring Session.
	 * 
	 * <pre>
	 * Spring Session provides an API and implementations for managing a user’s session information while also making it trivial to 
	 * support clustered sessions without being tied to an application container-specific solution.
	 * RESTful APIs: Spring Session lets providing session IDs in headers work with RESTful APIs. 
	 * 
	 * It also provides transparent integration with:
	 * 
	 * HttpSession: Allows replacing the HttpSession in an application container-neutral way, with support for providing session IDs in headers to work with RESTful APIs.
	 * 
	 * WebSocket: Provides the ability to keep the HttpSession alive when receiving WebSocket messages
	 * 
	 * WebSession: Allows replacing the Spring WebFlux’s WebSession in an application container-neutral way.
	 * </pre>
	 * 
	 * SessionRepositoryFilter is doing all to manage Spring session
	 * 
	 * - converts the HttpSession into a MongoSession
	 * 
	 * - checks if there's a Cookie present, and if so, loads the session data from
	 * the store saves the updated session data in the store
	 * 
	 * - checks the validity of the session
	 * 
	 * - creates a cookie with the name SESSION that is HttpOnly and secure. This
	 * cookie contains the session id, which is a Base64-encoded value.
	 * 
	 * @return
	 */
	/*
	 * @Bean public DefaultCookieSerializer customCookieSerializer() {
	 * DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
	 * 
	 * cookieSerializer.setUseHttpOnlyCookie(false);
	 * 
	 * return cookieSerializer; }
	 */
}
