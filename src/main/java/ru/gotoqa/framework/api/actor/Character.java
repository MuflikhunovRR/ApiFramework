
package ru.gotoqa.framework.api.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Character {
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;

}
