package net.sahet.vatinfo.repository.hal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import net.sahet.vatinfo.domain.hal.Book;

/**
 * We've extended the repository by adding two new endpoints:
 * 
 * findByTitleContaining – returns books that contain the query included in the
 * title findByAuthorContaining – returns books from the database where the
 * author of a book contains the query Note that our second endpoint contains
 * the export = false attribute. This attribute stops the HAL links being
 * generated for this endpoint, and won't be available via the HAL browser.
 * 
 * Finally, we'll load our data when Spring is started by defining a class which
 * implements the ApplicationRunner interface. You can find the code on GitHub.
 * 
 * https://www.baeldung.com/spring-rest-hal
 * 
 * Installing the HAL Browser The setup for the HAL browser is remarkably easy
 * when building a REST API with Spring. As long as we have the dependency,
 * Spring will auto-configure the browser, and make it available via the default
 * endpoint.
 * 
 *
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	@RestResource(rel = "title-contains", path = "title-contains")
	Page<Book> findByTitleContaining(@Param("query") String query, Pageable page);

	@RestResource(rel = "author-contains", path = "author-contains", exported = false)
	Page<Book> findByAuthorContaining(@Param("query") String query, Pageable page);
}
