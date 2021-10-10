package helpers;

import helpers.utils.APIUtils;
import io.restassured.response.Response;
import org.testng.Assert;

public class BEHelpers {

    APIUtils util;
    Response latestResponse;

    int requestedPageSize = 20;

    public BEHelpers() {
        util = new APIUtils();
    }

    public void verifyCodeOfLatestResponse(int expectedCode) {
        Assert.assertEquals(latestResponse.getStatusCode(), expectedCode, "Unexpected status code");
    }

    public void getSearchResult(String query) {
        latestResponse = util.getSearchResults(query, requestedPageSize);
    }

    /**
     * Done by comparing number of data vs pageSize attribute
     * NOTE: If data size = 0, pageSize = the requested pageSize sent through the param
     */
    public void verifyResultsCount() {
        int actualDataCount = latestResponse.jsonPath().getList("data.data").size();
        int statedPageSize = latestResponse.jsonPath().get("data.pageSize");

        if (actualDataCount == 0) {
            Assert.assertTrue(statedPageSize == requestedPageSize,
                    "if no results are given, stated page size should be same as requested page size"
            );
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
}
