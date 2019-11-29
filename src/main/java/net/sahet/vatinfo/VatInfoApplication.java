package net.sahet.vatinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * VatInfo Application to get Standard VAT Rates for countries with defined
 * criteria
 * 
 * @author azat satklichov
 *
 */
@SpringBootApplication
@EnableSwagger2
public class VatInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VatInfoApplication.class, args);
    }
}
