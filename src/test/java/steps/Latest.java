package steps;

import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class Latest implements En {
    private Response response;

    public Latest() {
        When("^User hits the api endpoint$", () -> {
            response = RestAssured.given()
                    .when().get("https://api.spacexdata.com/v4/launches/latest");
        });
        Then("^User should get the response code \"([^\"]*)\"$", (String statusCode) -> {
            int sCode = Integer.parseInt(statusCode);
            response.then().assertThat().statusCode(sCode);
        });
        Then("^User should get the date precision as \"([^\"]*)\"$", (String datePrecision) -> {
            String dPrecision = response.then().extract().path("date_precision");
            assert dPrecision.equalsIgnoreCase(datePrecision);
        });
        Then("^User should get the rocket, ships, capsules, payloads$", () -> {
            String body = response.getBody().asString();
            assert body.contains("rocket") && body.contains("ships") && body.contains("capsules") && body.contains("payloads");
        });
    }
}
