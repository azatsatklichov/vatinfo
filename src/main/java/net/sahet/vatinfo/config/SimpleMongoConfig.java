package net.sahet.vatinfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
//@Profile("prod")
@EnableMongoRepositories("net.sahet.vatinfo.repository.mongo")
public class SimpleMongoConfig extends AbstractMongoConfiguration {

	@Autowired
	MongoDbFactory mongoDbFactory;

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("127.0.0.1", 27017);
	}

	@Override
	protected String getMappingBasePackage() {
		return "net.sahet.vatinfo.repository.mongo";
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Bean
	public MongoClient mongo() {
		return new MongoClient("localhost");
	}

	/**
	 * Note: We didn't need to define MongoTemplate bean in the previous
	 * configuration as it's already defined in AbstractMongoConfiguration
	 */
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		// return new MongoTemplate(mongo(), "test");
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, getDefaultMongoConverter());
		return mongoTemplate;
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);

		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

		return mongoTemplate;
	}

//	@Bean
//	public CustomConversions customConversions() {
//		List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
//		converters.add(new TimeZoneReadConverter());
//		converters.add(new TimeZoneReadConverter());
//		return new CustomConversions(converters);
//	}

	@Bean
	public MappingMongoConverter mongoConverter() throws Exception {
		MongoMappingContext mappingContext = new MongoMappingContext();
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
		mongoConverter.setCustomConversions(customConversions());
		return mongoConverter;
	}

	@Bean
	public MappingMongoConverter getDefaultMongoConverter() throws Exception {
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory),
				new MongoMappingContext());
		return converter;
	}

}
