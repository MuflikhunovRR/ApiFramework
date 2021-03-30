
package ru.gotoqa.framework.api.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActorCast {
    @JsonProperty("Actor")
    private Actor actor;
    @JsonProperty("Character")
    private Character character;
    private String id;

}
