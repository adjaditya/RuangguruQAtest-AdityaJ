package helpers.pages;

import helpers.utils.FEUtils;
import org.testng.Assert;

/**
 * Page model for search results page. Contains locators and actions that can be done on this page
 */
public class SearchResultsPage extends FEUtils {

//    LOCATORS------------------------
    String searchResultsEntries = "xpath==//div//a[contains(@href, 'course')]";
    String pageResultSize = "xpath==//div[@data-testid='pagination-per-page']";
    String pageResultSizeChoices = pageResultSize + "//div[contains(@class,'menu')]";


    public void verifyNumberOfResultsIsCorrect(int expectedNumOfResults) {
        waitUntilElementPresent(searchResultsEntries);
        int actualNumOfResults = getElementsList(searchResultsEntries).size();
        Assert.assertEquals(actualNumOfResults, expectedNumOfResults, "Results count should be accurate");
    }

    public void changeResultsSize(int desiredSize) {
        clickElement(pageResultSize);

        String pageCountResultToClick = pageResultSizeChoices + "/div/div[text()='" + desiredSize + "']";
        if (!isElementPresent(pageCountResultToClick)) {
            Assert.fail("Invalid page results count of choice: " + desiredSize);
        }
        clickElement(pageCountResultToClick);
    }
}
