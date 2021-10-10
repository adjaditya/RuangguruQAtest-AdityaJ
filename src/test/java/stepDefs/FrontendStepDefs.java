package stepDefs;

import helpers.CommonFEHelper;
import helpers.pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;


public class FrontendStepDefs {

    CommonFEHelper common;
    SearchResultsPage searchResultsPage;

    public FrontendStepDefs() {
        common = new CommonFEHelper();
        searchResultsPage = new SearchResultsPage();
    }

    @After
    public void closeBrower() {
        common.closeDriver();
    }

    @Given("User is in Skill Academy's main page")
    public void userIsInSkillAcademySMainPage() {
        common.openUrl("https://skillacademy.com");
    }

    @Then("Verify that the search bar is visible")
    public void verifyThatTheSearchBarIsVisible() {
        common.verifySearchBarIsPresent();
    }

    @When("^User searches with query \"(.*)\"$")
    public void userSearchesWithQueryQuery(String query) {
        common.searchForQuery(query);
    }

    @Then("Verify that there are {int} results visible")
    public void verifyThatThereAreResultsVisible(int expectedNumOfResults) {
        searchResultsPage.verifyNumberOfResultsIsCorrect(expectedNumOfResults);
    }

    @When("User change the page results count to {int}")
    public void userChangeThePageResultsCountTo(int expectedResultsSize) {
        searchResultsPage.changeResultsSize(expectedResultsSize);
    }
}
