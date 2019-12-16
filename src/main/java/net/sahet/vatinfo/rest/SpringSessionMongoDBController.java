package net.sahet.vatinfo.rest;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSessionMongoDBController {
	
	/**
	 * After MongoTemplate integration, we have Duration-String Conversion issue. 
	 * 
	 * 
	 * But, even If mongo-session disabled in POM.xml,
	 * in-memory key-value is used to manage the SESSION  
	 */

	/**
	 * Spring Session provides an API and implementations for managing a user’s
	 * session information.
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
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<Integer> count(HttpSession session) {

		Integer counter = (Integer) session.getAttribute("count");

		if (counter == null) {
			counter = 1;
		} else {
			counter++;
		}

		session.setAttribute("count", counter);

		return ResponseEntity.ok(counter);
	}
}