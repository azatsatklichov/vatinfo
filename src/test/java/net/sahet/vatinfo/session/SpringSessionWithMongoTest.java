package net.sahet.vatinfo.session;
 
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import net.sahet.vatinfo.repository.mongo.CustomerRepository;

public class SpringSessionWithMongoTest {

	/*
	 * @Autowired private CustomerRepository customerRepository;
	 * 
	 * @org.junit.Test public void
	 * givenEndpointIsCalledTwiceAndResponseIsReturned_whenMongoDBIsQueriedForCount_thenCountMustBeSame
	 * () {
	 * 
	 * private MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
	 * 
	 * HttpEntity<String> response = mongoTemplate.exchange("http://localhost:" +
	 * 8080, HttpMethod.GET, null, String.class); HttpHeaders headers =
	 * response.getHeaders(); String set_cookie =
	 * headers.getFirst(HttpHeaders.SET_COOKIE);
	 * 
	 * Assert.assertEquals(response.getBody(),
	 * customerRepository.findById(getSessionId(set_cookie)).getAttribute("count").
	 * toString()); }
	 * 
	 * private String getSessionId(String cookie) { return new
	 * String(Base64.getDecoder().decode(cookie.split(";")[0].split("=")[1])); }
	 */
}
