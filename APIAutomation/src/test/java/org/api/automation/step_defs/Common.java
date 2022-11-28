package org.api.automation.step_defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.api.automation.base.APIBase;
import org.api.automation.base.ChaletsBase;
import org.api.automation.paths.ChaletsPaths;
import org.api.automation.paths.HotelPaths;
import java.util.Map;

public class Common extends APIBase {

    private RequestSpecification request;
    private JsonPath jsonPath;
    private Response response;

    @Given("^(.+) is added to the request$")
    public void query_parameter_is_added_to_the_request(String city) {
        try {
            request = generateLogs()
                    .header("token", prop.getProperty("token"))
                    .queryParam("query", city);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Given("Body is added to the post request")
    public void body_is_added_to_the_request() {
        try {
            request = generateLogs()
                    .header("content-type", "application/json")
                    .body(ChaletsBase.prepareBody());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @When("we hit the {string} request")
    public void we_hit_the_request(String httpType) {
        try {
            if (httpType.equalsIgnoreCase("post")) {
                response = request.when().contentType(ContentType.JSON).post(ChaletsPaths.LOAD_PAGE);
            } else {
                response = request.when().get(HotelPaths.SEARCH_HOTEL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Verify the status code is {int}")
    public void verify_the_status_code_is(int statusCode) {
        try {
            APIBase.verify_response_code(response, statusCode);
            APIBase.verify_Response_Header(response, "Content-Type", "application/json");
            response.prettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Then("Verify the response")
    public void verify_the_response(DataTable dataTable) {
        try {
            jsonPath = new JsonPath(response.getBody().asString());
            for (Map<String, String> data : dataTable.asMaps()) {
                verify_Response(response, data.get("key"), data.get("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

}
