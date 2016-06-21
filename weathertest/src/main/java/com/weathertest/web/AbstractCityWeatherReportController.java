package com.weathertest.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weathertest.service.WeatherService;
import com.weathertest.web.controller.WeatherReportResponse;

/**
 * TODO - Document this class
 * @author Raj
 *
 */
public class AbstractCityWeatherReportController {

    @Autowired
    protected WeatherService weatherService;

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    protected WeatherReportResponse getWeatherReportForCity(String cityName) throws JsonParseException, JsonMappingException, IOException {
        String weatherReporJson = weatherService.getWeatherReport(cityName);
        return mapFromJson(weatherReporJson, WeatherReportResponse.class);
    }
}
