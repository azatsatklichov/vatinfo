# VATINFO APPLICATION 
 VatInfo Application to get Standard VAT Rates for countries with defined   criteria
 
# Task
Implement an application in Java capable of printing out three EU countries with the lowest and three EU countries with 
the highest standard VAT rate as of today within the EU.  Input: http://jsonvat.com/
Suggestions: Keep it clean and simple (yet with a reasonable design allowing future extendibility), use any library of your choice, 
verify the program correctness, implement as a Maven or Gradle project, submit preferably as a GitHub repo link.

#Solution 
To make the application extensible, Spring Boot is used and application left open with easily extensible points (security, web templates, swagger,  lombok to decrease the coding etc. )
Also, swagger is provided, in case project is extended with more REST services 


#How to run application
Java8 is needed, then just from command line tool 

1. run "run.bat"  

2. Got to 

http://localhost:9090/vatRates
http://localhost:9090/displayRates

Junits


# Specification is not provided, in case yes, open points for clarification 
- JSON resource is not so well-formed, field names are not unique and not well data-typed



  
