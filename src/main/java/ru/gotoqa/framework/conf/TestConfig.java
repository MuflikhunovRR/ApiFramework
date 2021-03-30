package ru.gotoqa.framework.conf;

import lombok.Getter;

/**
 * Class for storing configurations
 */
@Getter
public class TestConfig {
    private String serviceUrl = "http://gotoqa.ru/test-data/";
    private String serviceWeatherUrl = "https://demoqa.com/utilities/weather/city/";
}
