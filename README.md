# VATINFO APPLICATION - https://github.com/azats/vatinfo

 VatInfo Application to get Standard VAT Rates for countries with defined   criteria
 
# Task
Implement an application in Java capable of printing out three EU countries with the lowest and three EU countries with 
the highest standard VAT rate as of today within the EU.  Input: http://jsonvat.com/
Suggestions: Keep it clean and simple (yet with a reasonable design allowing future extendibility), use any library of your choice, 
verify the program correctness, implement as a Maven or Gradle project, submit preferably as a GitHub repo link.

# Solution 
Java8 and SpringBoot is used to solve the task and implement the respective components. To make the application extensible for future,  application left open for easily extending with points like security, web templates e.g. thymeleaf, swagger,  lombok to decrease the coding etc.  Also, swagger is provided, in case project is extended with more REST services later


# How to setup/run/test application
Checkout the GitHub project, and just Java8 is needed in advance, then just from command line tool 

1. run "run.bat"  

2. Browse (by default 3 countries listed for each case: highest and lowest Standard VAT)
http://localhost:9091/vatRates

or with count parameter to define how many countries to list out  

http://localhost:9091/vatRates?count=5
http://localhost:9091/vatRates?count=12

http://localhost:9091/getCustomers?firstName=Alana&lastName=tolsto

Tests

1. Integration tests  - VatInfoAppRestTemplateTest
To run the integration test, application should be running 
> Run VatInfoAppTest.java 
 

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

  
