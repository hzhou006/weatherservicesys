                                                       Weather Service System

Description:

    1. I have created a repository on github to share my exercise.
    2. Base mapping: http://localhost:8080/weatherData
    3. Add a endpoint that responds to GET /fetchAllCitys. We can fetch all city name.
    4. Add an endpoint that responds to GET /fetchByName. We can fetch the weather(Fahreheit and Celsius) data by a city name
    5. Add an endpoint that response to GET / fetchMinMaxTempByTwoDates. We can fetch the daily min and max temperatures(Fahreheit and    Celsius) between 2016-09 and 2017-09
    6. Add an endpoint that responds to GET / calculateMeanTempPerWeek. This endpoint fetch the mean min and max temperature(Fahreheit and Celsius) for each week between 2016-09 and 2017-09
    7. Add an endpoint that responds to GET /calculateMeanTempPerMonth. This endpoint fetch the mean min and max temperature(Fahreheit and Celsius) for each Month between 2016-09 and 2017-09
    8. I encapsulate all API responses to include all weather data by using swagger.
Using Method: http://localhost:8080/swagger-ui.html#/    

Running Environment:

    1. Language: Java
    2. java version: "1.8.0_45"
    3. maven version: "3.3.3"
    4. Database: Mysql 5.7.19
    5. server: tomcat
    6. Swagger 2 and Swagger UI
    7. framework: Java Spring Boot

Database Description: 

    1. Type : Mysql
    2. Data from https://docs.google.com/spreadsheets/d/1gRk8izS2UzNvbGhHsHVPzUE4HmRliup-CUz1Q_88_kU/edit#gid=1652700924
    3. Data source URL: jdbc:mysql//127.0.0.1:3306/weather_db
    4. Database name: weather_db
    5. Username: root
    6. Password:

How to build the application: 

    1. Go to weatherservicesys folder
    2. $ mvn spring-boot:run

API Document Explain : 

    Link : http://localhost:8080/swagger-ui.html#/

There are 5 endpoints:	

    1.	GET http://localhost:8080/weatherData/fetchAllCitys

    2.	GET http://localhost:8080/weatherData/fetchByName
        →   Parameter name : (String)   
            Example: "BERKHOUT, NL"
    3.	GET http://localhost:8080/weatherData/fetchMinMaxTempByTwoDates
        →   Parameter1: startDate(String) , Parameter2: endDate(String)
            Example:  startDate = "2016-09"    endDate = "2017-09"
    4.	GET http://localhost:8080/weatherData/calculateMeanTempPerWeek
        →   Parameter1: startDate(String) , Parameter2: endDate(String)
            Example:  startDate = "2016-09"    endDate = "2017-09"
    5.	GET http://localhost:8080/weatherData/calculateMeanTempPerMonth
        →   Parameter1: startDate(String) , Parameter2: endDate(String)
            Example:  startDate = "2016-09"    endDate = "2017-09"
          
Running and Testing:

    Method1: Swagger running and testing 
    Method2: $mvn test
