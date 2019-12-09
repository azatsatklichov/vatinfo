package net.sahet.vatinfo.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fasterxml.jackson.core.Version;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

//https://www.baeldung.com/spring-boot-embedded-mongodb 

/*
 * class ManualEmbeddedMongoDbIntegrationTest { private MongodExecutable
 * mongodExecutable; private MongoTemplate mongoTemplate;
 * 
 * @After void clean() { mongodExecutable.stop(); }
 * 
 * @Before void setup() throws Exception { String ip = "localhost"; int port =
 * 27017;
 * 
 * IMongodConfig mongodConfig = new
 * MongodConfigBuilder().version(Version.Main.PRODUCTION) .net(new Net(ip, port,
 * Network.localhostIsIPv6())) .build();
 * 
 * MongodStarter starter = MongodStarter.getDefaultInstance(); mongodExecutable
 * = starter.prepare(mongodConfig); mongodExecutable.start(); mongoTemplate =
 * new MongoTemplate(new MongoClient(ip, port), "test"); }
 * 
 * @DisplayName("given object to save" +
 * " when save object using MongoDB template" + " then object is saved")
 * 
 * @Test void test() throws Exception { // given DBObject objectToSave =
 * BasicDBObjectBuilder.start() .add("key", "value") .get();
 * 
 * // when mongoTemplate.save(objectToSave, "collection");
 * 
 * // then assertThat(mongoTemplate.findAll(DBObject.class,
 * "collection")).extracting("key") .containsOnly("value"); } }
 */
