"# Weather-App-Backend-Spring-Boot"

This is the backend service for the WeatherApp project.
It provides secure REST APIs to fetch weather data from OpenWeatherMap and to manage city information from a local JSON file.
Authentication and authorization are handled using Auth0 JWT tokens

Features

Authentication & Authorization using Auth0 (JWT validation).
Weather API Integration with OpenWeatherMap
City Management from cities.json (local dataset).
DTO-based responses for clean API contracts.
Caching (5 minutes) to reduce redundant API calls.

Tech Stack

Java 17+
Spring Boot 3
Spring Security (OAuth2 Resource Server)
Auth0 for Authentication
RestTemplate for external API calls
Lombok for boilerplate reduction
Jackson for JSON parsing
OpenWeatherMap API

Project Structure

src/main/java/com/WeatherApp/WeatherApp
│── config/ # Security configuration
│── controllers/ # REST controllers
│── dtos/ # Data Transfer Objects (CityDto, WeatherDto)
│── model/ # City model (maps cities.json)
│── service/ # Business logic (WeatherService, CityService)
│── WeatherAppApplication # Main Spring Boot entry point

Configuration

1. Auth0 Setup

In your Auth0 Dashboard:
Create an API with identifier: https://weather-api
Configure an Application for your React frontend
Add callback/logout URLs for your frontend

2. Application Config

Set your variables in src/main/resources/application.yml:
spring:
security:
oauth2:
resourceserver:
jwt:
issuer-uri: https://<YOUR_AUTH0_DOMAIN>/
audience: https://weather-api

openweathermap:
api:
key: <YOUR_OPENWEATHERMAP_API_KEY>

Replace <YOUR_AUTH0_DOMAIN> with your Auth0 tenant (e.g., dev-xxxx.us.auth0.com)
Replace <YOUR_OPENWEATHERMAP_API_KEY> with your OpenWeatherMap API key.

Endpoints

Protected (requires Auth0 JWT)
GET /api/cities → Returns a list of cities (id, name) from cities.json.
GET /api/weather/{cityId} → Returns weather details for a given city.

Authentication Flow

User logs in from the frontend (React) via Auth0.
Auth0 returns an Access Token (JWT).
React sends the token in the Authorization: Bearer <token> header to backend.
Spring Boot validates the token (issuer + audience).
If valid → user can access /api/weather/** and /api/cities/**.

Running Locally

Clone the repo:

git clone https://github.com/<your-username>/WeatherApp-Backend.git
cd WeatherApp-Backend

Configure application.yml with your Auth0 + OpenWeatherMap credentials.

Run the backend:
mvn spring-boot:run

Backend runs at:
http://localhost:8080

Example Request with JWT

Using Postman or curl:
curl -H "Authorization: Bearer <YOUR_ACCESS_TOKEN>" http://localhost:8080/api/weather/1850147

Author

Developed by Tharindu Theekshana
