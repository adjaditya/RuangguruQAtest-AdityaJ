package helpers;

import helpers.utils.APIUtils;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class BEHelpers {

    APIUtils util;
    Response latestResponse;

    int requestedPage;
    int requestedPageSize;

    public BEHelpers() {
        util = new APIUtils();
        requestedPage = 1;
        requestedPageSize  = 20;
    }

    public void getSearchResult(String query) {
        latestResponse = util.getSearchResults(query, requestedPage, requestedPageSize);
    }

    public void getSearchResultWithPriceFilter(String query, int amount, String minOrMax) {
        if (minOrMax.equals("min")) { // test min price
            latestResponse = util.getSearchResultsWithPriceFilter(query, amount, 99999999);
        }
        else { // test max price
            latestResponse = util.getSearchResultsWithPriceFilter(query, 0, amount);
        }
    }

    public void verifyCodeOfLatestResponse(int expectedCode) {
        Assert.assertEquals(latestResponse.getStatusCode(), expectedCode, "Unexpected status code");
    }

    /**
     * Done by comparing number of data vs pageSize attribute
     * NOTE: If data size = 0, pageSize = the requested pageSize sent through the param
     */
    public void verifyResultsCount() {
        int actualDataCount = latestResponse.jsonPath().getList("data.data").size();
        int statedPageSize = latestResponse.jsonPath().get("data.pageSize");

        if (actualDataCount == 0) {
            Assert.assertEquals(requestedPageSize, statedPageSize, "if no results are given, stated page size should be same as requested page size");
        }
        else {
            Assert.assertEquals(actualDataCount, statedPageSize, "Data count did not mage state page size");
        }
    }

    public void verifyBeingInCertainPage(int expectedPage) {
        int actualPage = latestResponse.jsonPath().get("data.page");
        Assert.assertEquals(actualPage, expectedPage, "Currently in the wrong page");
    }

    public void verifyValueOfAnAttribute(String jsonPath, String expectedValue) {
        String actualValue = latestResponse.jsonPath().get(jsonPath);
        Assert.assertEquals(actualValue, expectedValue, "Value mismatch for jsonPath " + jsonPath);
    }

    public void verifyPriceFilter(String minOrMax, String price) {
        int amount = Integer.parseInt(price);
        List<Integer> allPrices = latestResponse.jsonPath().getList("data.data.basePrice");

        for (Integer currentPrice : allPrices) {
            if (minOrMax.equals("min")) { // minimum price must be above amount (inclusive)
                Assert.assertTrue(currentPrice >= amount, "There is a value below the minimum: " + currentPrice);
            }
            else { // max price must be below amount (inclusive)
                Assert.assertTrue(currentPrice <= amount, "There is a value above the maximum: " + currentPrice);
            }
        }
    }
}
