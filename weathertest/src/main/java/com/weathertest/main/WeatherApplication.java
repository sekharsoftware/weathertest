package com.weathertest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({
        "com.weathertest.main",
        "com.weathertest.model",
        "com.weathertest.service",
        "com.weathertest.service.impl",
        "com.weathertest.web.api",
        "com.weathertest.web.controller" })
/**
 * Weather service main application
 *
 * @author Raj
 */
public class WeatherApplication
{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherApplication.class, args);
    }
}
