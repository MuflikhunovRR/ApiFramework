
package ru.gotoqa.framework.api.actor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActorData {
    @JsonProperty("ActorCast")
    private List<ActorCast> actorCast;

}