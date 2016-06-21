package com.weathertest.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weathertest.web.AbstractCityWeatherReportController;

/**
 * TODO Document
 *
 * @author Raj
 */
@RestController
public class CityWeatherRestController extends AbstractCityWeatherReportController {

    @RequestMapping(value = "/api/weather-report/{cityName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCityWeatherReport(@PathVariable("cityName") String cityName) {
        return new ResponseEntity<String>(weatherService.getWeatherReport(cityName), HttpStatus.OK);
    }
}
