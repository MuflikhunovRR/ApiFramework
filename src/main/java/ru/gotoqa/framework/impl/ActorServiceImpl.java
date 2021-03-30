package ru.gotoqa.framework.impl;

import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import ru.gotoqa.framework.api.actor.ActorData;
import ru.gotoqa.framework.api.actor.ActorCast;
import ru.gotoqa.framework.conf.TestConfig;
import ru.gotoqa.framework.service.ActorService;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static ru.gotoqa.framework.context.RunContext.RUN_CONTEXT;

@Log4j2
public class ActorServiceImpl implements ActorService {

    TestConfig testConfig = new TestConfig();

    @Override
    public List<ActorCast> getActorList(String urlLink) {
        String url = testConfig.getServiceUrl() + urlLink;
        List<ActorCast> actors = new ArrayList<>();

        ValidatableResponse response = given().log().everything()
                .get(url)
                .then().log().ifError();

        RUN_CONTEXT.put("response", response);

        try {
            actors = response.extract().as(ActorData.class).getActorCast();
        } catch (Exception ex) {
            log.error("Actors request exception: " + actors);
        }
        return actors;
    }
}
