package net.sahet.vatinfo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("prod")
@EnableMongoRepositories("net.sahet.vatinfo.repository")
public class DatabaseConfiguration {
}
