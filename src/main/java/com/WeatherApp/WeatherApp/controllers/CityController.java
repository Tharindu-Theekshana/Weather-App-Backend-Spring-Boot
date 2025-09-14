package com.WeatherApp.WeatherApp.controllers;

import com.WeatherApp.WeatherApp.dtos.CityDto;
import com.WeatherApp.WeatherApp.model.City;
import com.WeatherApp.WeatherApp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/getCities")
    public ResponseEntity<List<CityDto>> getCities() {
        return cityService.getCities();
    }
}
