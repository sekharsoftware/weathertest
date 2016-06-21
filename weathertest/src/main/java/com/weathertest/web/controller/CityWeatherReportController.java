package com.weathertest.web.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.weathertest.web.AbstractCityWeatherReportController;


/**
 * TODO - Document this.
 *
 * @author Raj
 */
@Controller
public class CityWeatherReportController extends AbstractCityWeatherReportController {

    @RequestMapping(value = "/weather-report")
    public String getCityWeatherReport(@RequestParam(name = "cityName", required = false) String cityName, Model model) throws JsonParseException, JsonMappingException, IOException {

        if (StringUtils.hasText(cityName)) {
            model.addAttribute("report", getWeatherReportForCity(cityName));
        }

        return "weather-report";
    }
}
