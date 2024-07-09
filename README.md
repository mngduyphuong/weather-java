# Java Weather app

A Spring Boot application that fetches weather data from the OpenWeatherMap API and provides a REST endpoint to access this data.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Features](#features)
- [Live demo](#Live-demo)
- [Local installation and Testing](#Local-installation-and-testing)
- [Folder Structure](#Folder-Structure)
- [Contact](#contact)

## Technologies Used

- **Java**
- **Maven**
- **Springboot**
- **OpenWeatherMapAPI**
- **GitHub Actions**
- **AWS EC2**

## Features

- Fetch current weather data from the OpenWeather API
- Expose a REST endpoint to access weather data
- Health check endpoint for monitoring
- Basic unit testing for the REST endpoint and service layer
- CI/CD pipeline to deploy the application to AWS EC2
- API key and AWS keys are kept secret

## Live demo
You can access the live demo of the Java Weather App using the following endpoints:
#### Health Check Endpoint
To check if the application is up and running, access the health check endpoint:
```
http://ec2-3-106-189-38.ap-southeast-2.compute.amazonaws.com:8080/healthcheck
```
#### Weather Data Endpoint
To fetch weather data for a specific location, use the weather endpoint. Replace 'melbourne,au' with your desired location:
```
http://ec2-3-106-189-38.ap-southeast-2.compute.amazonaws.com:8080/weather?location=melbourne,au
```

## Local installation and Testing
#### Prerequisites
- JDK 17 or higher
- OpenWeatherMap API key
- Maven
To run the application in local environment, please follow the below steps:
- Clone the repository:
```
git clone https://github.com/mngduyphuong/weather-java
cd weather-java
```
- Open the application.properties file located in src/main/resources and add your OpenWeather API key:
```
OPENWEATHER_API_KEY=<YOUR_OPENWEATHER_API_KEY>
```
- Run Unit testing
```
mvn test
```
- Run the application:
```
mvn spring-boot:run
```

## Folder Structure
Below is the main folder structure of the application:
```
weather-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── performio/weather_app/
│   │   │       ├── controller/
│   │   │       │   └── WeatherController.java
│   │   │       ├── service/
│   │   │       │   └── WeatherService.java
│   │   │       ├── model/
│   │   │       │   └── WeatherModel.java
│   │   │       ├── config/
│   │   │       │   └── OpenWeatherConfig.java
│   │   │       └── WeatherAppApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── performio/weather_app/
│               └── WeatherAppApplicationTests.java
├── .github/
│   └── workflows/
│       └── deploy.yml
├── pom.xml
└── README.md

```

## Contact

For any inquiries or feedback, please feel free to reach out:

- Email: mngduyphuong@gmail.com
- LinkedIn: https://www.linkedin.com/in/mngduyphuong/
- GitHub: https://github.com/mngduyphuong

Thank you for visiting my project! 🎉
