package com.mytheresa.challenge.tests;

import com.mytheresa.challenge.data.TestData;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.hasKey;

/**
 * SearchRepositoriesTest class to contain assigned Test as required
 * Uses RestAssured API methods to validate response
 */
public class SearchRepositoriesTest extends BaseTest {

    private String path = "search/repositories";

    /**
     * Test status code
     * @param queryParams Query params from DataProvider class
     */
    @Test(description = "Validate that status code to search/repositories endpoint is 200",
            dataProviderClass = TestData.class,
            dataProvider = "query-data-provider")

    public void validateStatusCode(HashMap<String, String> queryParams) {
        response = sendHttpRequest(request, queryParams, path)
                .then()
                .statusCode(200);
    }

    /**
     * Test to validate presence of required keys in Response
     * @param queryParams Query params from DataProvider class
     */
    @Test(description = "Validate that keys 'total_count', 'incomplete_results' and 'items' are present in response.",
            dataProviderClass = TestData.class,
            dataProvider = "query-data-provider")

    public void validateKeysPresent(HashMap<String, String> queryParams) {
        response = sendHttpRequest(request, queryParams, path)
                .then()
                .body("$", hasKey("total_count"))
                .body("$", hasKey("incomplete_results"))
                .body("$", hasKey("items"));
    }
}
