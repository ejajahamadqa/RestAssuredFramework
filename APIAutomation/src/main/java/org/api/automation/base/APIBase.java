package org.api.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class APIBase {

    public static Properties prop;
    RequestSpecification requestSpecification;
    private long max_response_time = 300;

    public APIBase() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("./src/test/resources/config/common.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * To generate the logs
     */
    public RequestSpecification generateLogs() {
        return given().log().all();
    }

    /**
     * Add Single Header
     * @param headerKey
     * @param headerValue
     */
    public RequestSpecification addHeaders(String headerKey, String headerValue) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(headerKey, headerValue);
        return requestSpecification.header((Header) headerMap);
    }

    /**
     * To print the logs in a specific file
     */
    public RequestSpecification requestSpecification() throws FileNotFoundException {
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        requestSpecification.given().filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log));

        return requestSpecification;
    }

    /**
     * Verify response code.
     * @param res           response object to be verified
     * @param response_code response status value to asserted for
     */
    public static void verify_response_code(Response res, int response_code) {
        res.then().log().all().assertThat().statusCode(response_code);
    }

    /**
     * Verify Headers of the response
     * @param res Response object
     * @param key Path of the object key
     * @param value value of the object key
     */
    public static void verify_Response_Header(Response res, String key, String value) {
        res.then().log().all().assertThat().header(key, value);
    }

    /**
     * Verify response with path of the key and value.
     * @param res Response object to verify the response code
     * @param key Path of the object key
     * @param value value of the object key
     */
    public static void verify_Response(Response res, String key, String value) {

        JsonPath jsonPath = new JsonPath(res.then().log().all().extract().asString());
        for (int i = 0; i < jsonPath.getInt(key + ".size()"); i++) {
            if (jsonPath.get(key + "[" + i + "]").equals(value)) {
                System.out.println("Data verified ");
                break;
            }
        }
    }


    /**
     * Verify response time.
     * @param res Response object to verify the response code
     */
    public void verify_response_time(Response res) {
        res.then()
                .assertThat()
                .time(Matchers.lessThan(max_response_time));
    }
}
