package com.WeatherApp.WeatherApp.controllers;
import com.WeatherApp.WeatherApp.dtos.WeatherDto;
import com.WeatherApp.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getWeather/{cityId}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable int cityId){
        return weatherService.getWeather(cityId);
    }
}
