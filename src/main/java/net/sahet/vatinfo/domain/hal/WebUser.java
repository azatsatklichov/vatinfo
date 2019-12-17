package net.sahet.vatinfo.domain.hal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * It also is important to note that Spring Data REST automatically follows the
 * principles of HATEOAS. HATEOAS is one of the constraints of the REST
 * architecture style, and it means that hypertext should be used to find your
 * way through the API.
 * 
 */
@Entity
@Getter
@Setter
public class WebUser {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String email;
}
