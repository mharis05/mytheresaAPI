package com.mytheresa.challenge.data;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class TestData {

    /**
     * Data provider for URL parameters consumed by Tests
     *
     * @return HashMap with query parameter values.
     */
    @DataProvider(name = "query-data-provider")
    public static Object[] dataProviderMethod() {
        return new Object[]{
                queryParams
        };
    }

    private static HashMap<String, String> queryParams = new HashMap<String, String>() {
        {
            put("q", "tetris+language:assembly");
            put("sort", "stars");
            put("order", "desc");
        }
    };

    /**
     * Data provider for URL parameters consumed by Tests
     *
     * @return HashMap with query parameter values.
     */
    @DataProvider(name = "custom-data-provider")
    public static Object[][] customDataProviderMethod() {
        return new Object[][]{
                {
                        customQueryParams,
                        customTestData
                }
        };
    }

    private static HashMap<String, String> customQueryParams = new HashMap<String, String>() {
        {
            put("q", "cypress+nodejsin:readme+user:mharis05+language:javascript");
            put("sort", "updated");
            put("order", "desc");
        }
    };

    private static HashMap<String, String> customTestData = new HashMap<String, String>() {
        {
            put("ownerUserId", "mharis05");
            put("ownerUrl", "https://api.github.com/users/mharis05");
            put("language", "JavaScript");
            put("totalCount", "1");
        }

    };
}
