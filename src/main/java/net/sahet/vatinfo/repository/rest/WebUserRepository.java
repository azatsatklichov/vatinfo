package net.sahet.vatinfo.repository.rest;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.sahet.vatinfo.domain.WebUser;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public class WebUserRepository extends PagingAndSortingRepository<WebUser, Long> {
	List<WebUser> findByName(@Param("name") String name);
}