package ru.gotoqa.framework.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import ru.gotoqa.framework.api.weather.Weather;
import ru.gotoqa.framework.impl.WeatherServiceImpl;
import ru.gotoqa.framework.service.WeatherService;

import java.util.Map;

import static ru.gotoqa.framework.context.RunContext.RUN_CONTEXT;

/**
 * Steps class
 */
public class WeatherStep {
    WeatherService service = new WeatherServiceImpl();

    @Given("Get Weather {string} Request")
    public void getWeatherRq(String url) {
        service.getWeatherInfo(url);
    }

    @Then("Weather Response code is: {int}")
    public void responseCodeWeather(int expectedStatus) {
        ValidatableResponse response =
                RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        Assertions.assertEquals(expectedStatus, actualStatus,
                "Incorrect Status code in response");
    }

    @Then("Check Weather data in response")
    public void checkResponse(Map<String, String> map) {
        ValidatableResponse vaRs =
                RUN_CONTEXT.get("response", ValidatableResponse.class);
        Weather response = vaRs.extract().as(Weather.class);

        Assertions.assertEquals(
                map.get("City"), response.getCity(), "Incorrect City in response");
        Assertions.assertEquals(
                map.get("Temperature"),
                response.getTemperature().substring(response.getTemperature().length() - 14),
                "Incorrect Temperature in response");
    }
}
