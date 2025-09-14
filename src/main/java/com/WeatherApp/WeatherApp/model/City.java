package com.WeatherApp.WeatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    @JsonProperty("CityCode")
    private int id;

    @JsonProperty("CityName")
    private String name;

    @JsonProperty("Temp")
    private String temp;

    @JsonProperty("Status")
    private String status;
}
