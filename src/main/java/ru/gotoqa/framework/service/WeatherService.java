package ru.gotoqa.framework.service;

import ru.gotoqa.framework.api.weather.Weather;

public interface WeatherService {
    Weather getWeatherInfo(String url);
}
