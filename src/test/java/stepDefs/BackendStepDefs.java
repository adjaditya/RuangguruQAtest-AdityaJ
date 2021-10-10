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
}