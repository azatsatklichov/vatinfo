package net.sahet.vatinfo.session;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

/*
 * @DataMongoTest
 * 
 * @ExtendWith(SpringExtension.class) public class MongoDbSpringIntegrationTest
 * {
 * 
 * @DisplayName("given object to save" +
 * " when save object using MongoDB template" + " then object is saved")
 * 
 * @Test public void test(@Autowired MongoTemplate mongoTemplate) { // given
 * DBObject objectToSave = BasicDBObjectBuilder.start().add("key",
 * "value").get();
 * 
 * // when mongoTemplate.save(objectToSave, "collection");
 * 
 * // then assertThat(mongoTemplate.findAll(DBObject.class,
 * "collection")).extracting("key").containsOnly("value"); } }
 */