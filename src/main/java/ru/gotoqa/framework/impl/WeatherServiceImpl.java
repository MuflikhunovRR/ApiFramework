package ru.gotoqa.framework.impl;

import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import ru.gotoqa.framework.api.weather.Weather;
import ru.gotoqa.framework.conf.TestConfig;
import ru.gotoqa.framework.service.WeatherService;

import static io.restassured.RestAssured.given;
import static ru.gotoqa.framework.context.RunContext.RUN_CONTEXT;

@Log4j2
public class WeatherServiceImpl implements WeatherService {

    TestConfig testConfig = new TestConfig();

    @Override
    public Weather getWeatherInfo(String urlLink) {
        String url = testConfig.getServiceWeatherUrl() + urlLink;
        Weather weather = null;

        ValidatableResponse response = given().log().everything()
                .get(url)
                .then().log().ifError();

        RUN_CONTEXT.put("response", response);

        try {
            weather = response.extract().as(Weather.class);
        } catch (Exception ex) {
            log.error("Weather request exception: " + weather);
        }
        return weather;
    }
}
