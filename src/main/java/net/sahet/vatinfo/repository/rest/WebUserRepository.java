package net.sahet.vatinfo.repository.rest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.sahet.vatinfo.domain.rest.WebUser;

/**
 * The @RepositoryRestResource annotation is optional and is used to customize
 * the REST endpoint. If we decided to omit it, Spring would automatically
 * create an endpoint at “/webUsers” instead of “/users“.
 * 
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface WebUserRepository extends PagingAndSortingRepository<WebUser, Long> {

	List<WebUser> findByName(@Param("name") String name);
}