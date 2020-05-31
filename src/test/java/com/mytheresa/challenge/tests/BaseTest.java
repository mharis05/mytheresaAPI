package com.mytheresa.challenge.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * BaseTest class to contain common functionalities to be
 * consumed by child test classes
 */
public class BaseTest {

    protected static ResourceBundle propertyValues;
    Locale locale = new Locale("en", "US");
    protected RequestSpecification request = RestAssured.with();
    protected ValidatableResponse response;

    /**
     * Set up configurations for tests
     */
    @BeforeTest
    public void initializeDependencies() {
        propertyValues = ResourceBundle.getBundle("config", locale);
        request.given()
                .baseUri(propertyValues.getString("baseUri"))
                .accept(ContentType.JSON)
                .headers("Connection", "keep-alive")
                .urlEncodingEnabled(false);
    }

    /**
     * Re-usable HttpRequest method for consumption in tests
     * @param request Http Request object
     * @param queryParams Query parameters to append
     * @param path Uri path
     * @return Response object
     */
    protected Response sendHttpRequest(RequestSpecification request, HashMap<String, String> queryParams, String path) {
        return request
                .when()
                .queryParams(queryParams)
                .get(path);
    }

}
