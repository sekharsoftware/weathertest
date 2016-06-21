package com.weathertest.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO Document
 * @author Raj
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReportResponse {
    public final Weather weather[];
    public final Main main;
    public final Date dt;
    public final Sys sys;
    public final String name;

    @JsonCreator
    public WeatherReportResponse(@JsonProperty("weather") Weather[] weather, @JsonProperty("main") Main main, @JsonProperty("dt") Date dt, @JsonProperty("sys") Sys sys, @JsonProperty("name") String name) {
        this.weather = weather;
        this.main = main;
        this.dt = dt;
        this.sys = sys;
        this.name = name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Weather {
        public final String description;

        @JsonCreator
        public Weather(@JsonProperty("description") String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Main {
        public final double temp;

        @JsonCreator
        public Main(@JsonProperty("temp") double temp) {
            this.temp = temp;
        }

        public double getTemp() {
            return temp;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Sys {
        public final Timestamp sunrise;
        public final Timestamp sunset;

        @JsonCreator
        public Sys(@JsonProperty("sunrise") Timestamp sunrise, @JsonProperty("sunset") Timestamp sunset) {
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        public Timestamp getSunrise() {
            return sunrise;
        }

        public Timestamp getSunset() {
            return sunset;
        }

    }

    public Weather[] getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Date getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }
}