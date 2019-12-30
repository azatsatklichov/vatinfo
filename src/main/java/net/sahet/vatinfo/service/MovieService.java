package net.sahet.vatinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import net.sahet.vatinfo.domain.mongo.Movie;

public class MovieService {

	// https://www.baeldung.com/spring-data-mongodb-tutorial
	/**
	 * The MongoTemplate follows the standard template pattern in Spring and
	 * provides a ready to go, basic API to the underlying persistence engine.
	 * 
	 * 
	 * The repository (MongoRepository) follows the Spring Data-centric approach and
	 * comes with more flexible and complex API operations, based on the well-known
	 * access patterns in all Spring Data projects.
	 */
	@Autowired
	MongoTemplate mongoTemplate;

	public int getMovie(Movie movie) {
		//mongoTemplate.find
		return 0;

	}

	public int insert(Movie movie) {

		mongoTemplate.insert(movie, "kino");

		return 0;

	}

	/**
	 * The save operation has save-or-update semantics
	 * 
	 * 
	 * @param movie
	 * @return
	 */
	public int save(Movie movie) {

		Movie kino = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Aygytly Adim")), Movie.class);
		kino.setName("Aygytly Adim kinofilmi");

		mongoTemplate.save(kino, "kino");

		// update first
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Aygytly Adim"));
		Update update = new Update();
		update.set("name", "Aygytly Adim kinofilm");
		mongoTemplate.updateFirst(query, update, Movie.class);

		return 0;

	}

}
