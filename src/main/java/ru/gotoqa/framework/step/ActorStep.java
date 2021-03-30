package ru.gotoqa.framework.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import ru.gotoqa.framework.impl.ActorServiceImpl;
import ru.gotoqa.framework.service.ActorService;

import static ru.gotoqa.framework.context.RunContext.RUN_CONTEXT;

/**
 * Steps class
 */
public class ActorStep {
    ActorService service = new ActorServiceImpl();

    @Given("Get Artists {string} Request")
    public void getArtistsRequest(String url) {
        service.getActorList(url);
    }

    @Then("Response code is: {int}")
    public void responseCodeIs(int expectedStatus) {
        ValidatableResponse response =
                RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        Assertions.assertEquals(expectedStatus, actualStatus,
                "Incorrect Status code in response");
    }

}
