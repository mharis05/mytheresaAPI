package com.mytheresa.challenge.tests;

import com.mytheresa.challenge.data.TestData;
import com.mytheresa.challenge.model.RepositoriesResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

/**
 * CustomQueryTest class
 * Purpose: For demonstration of utilizing JSON Deserialization to
 * write readable, maintainable API Tests.
 */
public class CustomQueryTest extends BaseTest {

    private String path = "search/repositories";

    /**
     * Test that uses one of my personal github repos as test subject
     * Uses JSON (De)serialization to validate response values
     * @param queryParams Query parameters
     * @param customData Expected data in form of a Hashmap
     */
    @Test(description = "Validate that correct values for Repository information are returned.",
            dataProviderClass = TestData.class,
            dataProvider = "custom-data-provider")

    public void validatePersonalGithubRepos(HashMap<String, String> queryParams, HashMap<String, String> customData) {

        // Deserialize response to POJO
        RepositoriesResponse repositoriesResponse =
                sendHttpRequest(request, queryParams, path).as(RepositoriesResponse.class);

        // Perform readable, cleaner assertions
        Assert.assertEquals(repositoriesResponse.getItems().get(0).getOwner().getLogin(), customData.get("ownerUserId"));
        Assert.assertEquals(repositoriesResponse.getItems().get(0).getOwner().getUrl(), customData.get("ownerUrl"));
        Assert.assertEquals(repositoriesResponse.getItems().get(0).getLanguage(), customData.get("language"));
        Assert.assertEquals(String.valueOf(repositoriesResponse.getItems().size()), customData.get("totalCount"));
    }
}
