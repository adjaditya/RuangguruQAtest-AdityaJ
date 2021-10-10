package helpers;

import helpers.utils.FEUtils;
import org.testng.Assert;

/**
 * Common FE methods that can be used accross all Skill Academy pages
 */
public class CommonFEHelper extends FEUtils {

//    LOCATORS------------------------
    String mainSearchBar = "xpath==//input[@placeholder='Kamu ingin menguasai skill apa hari ini?']";

    public void openUrl(String url) {
        initiateBrowser(url);
    }

    public void closeDriver() {
        closeBrowserSession();
    }

    public void verifySearchBarIsPresent() {
        Assert.assertTrue(isElementPresent(mainSearchBar), "Search bar should be present");
    }

    public void searchForQuery(String query) {
        editInput(mainSearchBar, query);
        clickEnter(mainSearchBar);
    }
}
