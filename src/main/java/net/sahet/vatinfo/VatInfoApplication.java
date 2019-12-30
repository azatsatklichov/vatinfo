package net.sahet.vatinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Azat Satklichov
 *
 */
@SpringBootApplication
@EnableSwagger2 ////@EnableSwagger2WebMvc
public class VatInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VatInfoApplication.class, args);
	}
}
