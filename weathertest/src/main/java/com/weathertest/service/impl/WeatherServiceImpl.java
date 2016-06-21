package com.weathertest.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weathertest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    private Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Value("${weather.data.url}")
    private String weatherDataURL;

    @Override
    public String getWeatherReport(String cityName) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> vars = new HashMap<String, String>();
        vars.put("cityName", cityName);

        logger.debug("Returning weather report for city {}", cityName);

        return restTemplate.getForObject(weatherDataURL, String.class, vars);
    }
}
