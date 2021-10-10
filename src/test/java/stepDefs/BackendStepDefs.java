package stepDefs;

import helpers.BEHelpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackendStepDefs {

    BEHelpers helper;

    public BackendStepDefs() {
        helper = new BEHelpers();
    }

    @When("User GET search results with query {string}")
    public void userGETSearchResultsWithQuery(String query) {
        helper.getSearchResult(query);
    }

    @Then("Verify that API call was successful with code {int}")
    public void verifyThatAPICallWasSuccessfulWithCode(int expectedCode) {
        helper.verifyCodeOfLatestResponse(expectedCode);
    }

    @And("Verify results count is accurate")
    public void verifyResultsCountIsAccurate() {
        helper.verifyResultsCount();
    }

    @And("Verify user is in page {int}")
    public void verifyUserIsInPage(int pageNum) {
        helper.verifyBeingInCertainPage(pageNum);
    }

    @And("Verify status and message says success")
    public void verifyStatusAndMessageSaysSuccess() {
        helper.verifyValueOfAnAttribute("status", "success");
        helper.verifyValueOfAnAttribute("message", "success");
    }

    @When("^User GET search results with query ([a-z|A-Z]*) and ([0-9]*) (min|max) price$")
    public void userGETSearchResultsWithQueryAndMinPrice(String query, int amount, String minOrMax) {
        helper.getSearchResultWithPriceFilter(query, amount, minOrMax);
    }

    @Then("^Verify that all prices in the results satisfy (min|max) price condition for amount ([0-9]*)$")
    public void verifyThatAllPricesInTheResultsSatisfyMinOrMaxPriceConditionForAmountPrice(String minOrMax, String price) {
        helper.verifyPriceFilter(minOrMax, price);
    }
}