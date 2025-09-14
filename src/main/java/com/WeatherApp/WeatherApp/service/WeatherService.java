package com.WeatherApp.WeatherApp.service;

import com.WeatherApp.WeatherApp.dtos.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "weather", key = "#cityId")
    public ResponseEntity<WeatherDto> getWeather(int cityId) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?id="
                    + cityId + "&appid=" + apiKey + "&units=metric";

            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            String cityName = (String) response.get("name");

            List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
            String description = weatherList != null && !weatherList.isEmpty()
                    ? (String) weatherList.get(0).get("description")
                    : "N/A";

            Map<String, Object> main = (Map<String, Object>) response.get("main");
            double temperature = main != null ? ((Number) main.get("temp")).doubleValue() : 0.0;

            WeatherDto weatherDto = new WeatherDto();
            weatherDto.setCityName(cityName);
            weatherDto.setDescription(description);
            weatherDto.setTemperature(temperature);

            return ResponseEntity.ok(weatherDto);
        }catch(RuntimeException e){
            throw new RuntimeException("cant get weather : ",e);
        }
    }
}
