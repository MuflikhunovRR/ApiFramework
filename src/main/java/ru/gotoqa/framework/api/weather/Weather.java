
package ru.gotoqa.framework.api.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {
    @JsonProperty("City")
    private String city;
    @JsonProperty("Humidity")
    private String humidity;
    @JsonProperty("Temperature")
    private String temperature;
    @JsonProperty("Weather Description")
    private String weatherDescription;
    @JsonProperty("Wind Direction degree")
    private String windDirectionDegree;
    @JsonProperty("Wind Speed")
    private String windSpeed;

}
