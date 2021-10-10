package stepDefs;

import helpers.CommonFEHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.*;


public class FrontendStepDefs {

    CommonFEHelper helper = new CommonFEHelper();

    @Given("User is in Skill Academy's main page")
    public void userIsInSkillAcademySMainPage() {
        helper.openUrl("https://skillacademy.com");
    }

    @Then("Verify that the search bar is visible")
    public void verifyThatTheSearchBarIsVisible() {
        helper.verifySearchBarIsPresent();
    }

    @After
    public void closeBrower() {
        helper.closeDriver();
    }
}
