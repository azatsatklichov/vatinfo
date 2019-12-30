package net.sahet.vatinfo.repository.hal;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.sahet.vatinfo.domain.hal.WebUser;

/**
 * The @RepositoryRestResource annotation is optional and is used to customize
 * the REST endpoint. If we decided to omit it, Spring would automatically
 * create an endpoint at “/webUsers” instead of “/users“.
 * 
 * It also is important to note that Spring Data REST automatically follows the
 * principles of HATEOAS. HATEOAS is one of the constraints of the REST
 * architecture style, and it means that hypertext should be used to find your
 * way through the API.
 * 
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface WebUserRepository extends PagingAndSortingRepository<WebUser, Long> {

	List<WebUser> findByName(@Param("name") String name);
}