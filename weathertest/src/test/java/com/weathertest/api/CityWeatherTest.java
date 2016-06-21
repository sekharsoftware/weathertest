package com.weathertest.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.weathertest.main.WeatherApplication;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WeatherApplication.class)
/**
 * TODO Document
 * @author Raj
 */
public class CityWeatherTest {

    private static final String FAILURE_RESPONSE_CODE_IS_NOT_RIGHT = "failure - response code is not right";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void connectToWeatherReportApiEndpoint() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult returnResponse = mockMvc.perform(MockMvcRequestBuilders.get("/api/weather-report/London").accept(MediaType.APPLICATION_JSON)).andReturn();

        assertEquals(FAILURE_RESPONSE_CODE_IS_NOT_RIGHT, 200, returnResponse.getResponse().getStatus());
    }

    @Test
    public void getReportForACity() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult returnResponse = mockMvc.perform(MockMvcRequestBuilders.get("/api/weather-report/London").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andReturn();

        assertEquals(FAILURE_RESPONSE_CODE_IS_NOT_RIGHT, 200, returnResponse.getResponse().getStatus());
        String responseJsonData = returnResponse.getResponse().getContentAsString();
        assertTrue("failure - weather report for city is not received", responseJsonData.length() > 0);

        Assert.hasText(responseJsonData);
        assertTrue(responseJsonData.contains("London"));
    }
}
