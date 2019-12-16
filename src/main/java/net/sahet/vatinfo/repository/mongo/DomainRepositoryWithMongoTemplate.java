package net.sahet.vatinfo.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

import net.sahet.vatinfo.domain.Domain;

//Impl postfix of the name on it compared to the core repository interface
public class DomainRepositoryWithMongoTemplate {

	@Autowired
	MongoTemplate mongoTemplate;

	public int updateDomain(String domain, boolean displayAds) {

		Query query = new Query(Criteria.where("domain").is(domain));
		Update update = new Update();
		update.set("displayAds", displayAds);

		UpdateResult result = mongoTemplate.updateFirst(query, update, Domain.class);

		if (result != null)
			return result.hashCode();
		else
			return 0;
	}
}