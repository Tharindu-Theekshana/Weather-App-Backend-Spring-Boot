package com.WeatherApp.WeatherApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private String cityName;
    private String description;
    private double temperature;
}
