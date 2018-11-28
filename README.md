# VATINFO APPLICATION 
 VatInfo Application to get Standard VAT Rates for countries with defined   criteria
 
# Task
Implement an application in Java capable of printing out three EU countries with the lowest and three EU countries with 
the highest standard VAT rate as of today within the EU.  Input: http://jsonvat.com/
Suggestions: Keep it clean and simple (yet with a reasonable design allowing future extendibility), use any library of your choice, 
verify the program correctness, implement as a Maven or Gradle project, submit preferably as a GitHub repo link.

# Solution 
To make the application extensible, Spring Boot is used and application left open for easily extending points (security, web templates e.g. thymeleaf, swagger,  lombok to decrease the coding etc. )
Also, swagger is provided, in case project is extended with more REST services later


# How to setup/run application
Checkout the GitHub project, and just Java8 is needed in advance, then just from command line tool 

1. run "run.bat"  

2. Browse 

http://localhost:9090/vatRates
http://localhost:9090/vatRates?count=4
http://localhost:9090/vatRates?count=5



Junits
There are some Unit tests to test if application works correctly
1. Run JUnits 
 



  
