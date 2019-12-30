# VATINFO APPLICATION - https://github.com/azatsatklichov/vatinfo

 VatInfo Application to get Standard VAT Rates for countries with defined  criteria
 
# Task
Implement an application in Java capable of printing out three EU countries with the lowest and three EU countries with 
the highest standard VAT rate as of today within the EU.  Input: http://jsonvat.com/

# Solution 
Java and SpringBoot is used to solve the task and implement the respective components. 
To make the application extensible for future,  application left open for easily extending with points like security, web templates e.g. thymeleaf, swagger, HAL, Spring Data JPA, Spring Session, Spring Data Mongo to decrease the coding etc.  Also, swagger is provided, in case project is extended with more REST services later


# How to setup/run/test application
Checkout the GitHub project, and just Java8 is needed in advance, then just from command line tool 

Just Precondition 
- Running Mongo DB localhost:27017 with TEST database is needed, in case not, just you may skipp some functionalities then 

1. run "run-dev.bat"  


#Testing

1. Browse for highest and lowest Standard VAT 

http://localhost:9091/vatRates?count=5

http://localhost:9091/vatRates?count=12

2. with prod-profile (under progress)
 
http://localhost:9091/vatRates?count=12


2. Or just use POSTMAN client  with GET method 
http://localhost:9091/vatRates

Response:

{
    "CountriesWithHighestStandardVATRates": [
        "Luxembourg",
        "Malta",
        "Cyprus"
    ],
    "CountriesWithLowestStandardVATRates": [
        "Hungary",
        "Sweden",
        "Denmark"
    ]
}


http://localhost:9091/vatRates?count=5

{
    "CountriesWithHighestStandardVATRates": [
        "Luxembourg",
        "Malta",
        "Cyprus",
        "Romania",
        "Germany"
    ],
    "CountriesWithLowestStandardVATRates": [
        "Hungary",
        "Sweden",
        "Denmark",
        "Croatia",
        "Finland"
    ]
}


3. Use Swagger to test the application

http://localhost:9091/swagger-ui.html


3. Browse for Mongo: e.g. http://localhost:9090/getCustomers?firstName=Alana&lastName=tolsto
 

4. Integration tests  - VatInfoAppRestTemplateTest
To run the integration test, application should be running 
> Run VatInfoAppTest.java 
 

  
#TODO
 - adjust profiles
 - improve Spring Data Mongo  
 - Spring Sessions, Security etc. 

