package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonFEHelper {

//    LOCATORS------------------------
    String mainSearchBar = "xpath==//input[@placeholder='Kamu ingin menguasai skill apa hari ini?']";

    FEUtils feUtil;

    public CommonFEHelper() {
        feUtil = new FEUtils();
    }

    public void openUrl(String url) {
        feUtil.openUrl(url);
    }

    public void closeDriver() {
        feUtil.closeDriver();
    }

    public void verifySearchBarIsPresent() {
        Assert.assertTrue(feUtil.isElementPresent(mainSearchBar), "Search bar should be present");
    }
}
