package helpers.pages;

import helpers.utils.FEUtils;
import org.testng.Assert;

/**
 * Page model for search results page. Contains locators and actions that can be done on this page
 */
public class SearchResultsPage extends FEUtils {

//    LOCATORS------------------------
    String searchResultsEntries = "xpath==//div[not(contains(@class,'slick-slide'))]/div/div/a[contains(@href, 'course')]";
    String pageResultSize = "xpath==//div[@data-testid='pagination-per-page']";
    String pageResultSizeChoices = pageResultSize + "//div[contains(@class,'menu')]";
    String availableResultsText = "xpath==//div[@data-testid='pagination-per-page']/following-sibling::div/p";
    String emptyResultsIndicator = "xpath==//div[@data-testid='empty-result-card']";
    String nextPageBtn = "xpath==//div[@data-testid='pagination-next']";
    String hightlightedPageIcon = "css==.css-1g3hvr7 .css-wc5b3e";


    public void verifyNumberOfResultsIsCorrect(int expectedNumOfResults) throws InterruptedException {
        Thread.sleep(1000);
        int actualNumOfResults = getElementsList(searchResultsEntries).size();

        if (isElementPresent(availableResultsText)) {
            int availableResults = Integer.valueOf(getText(availableResultsText).replaceAll("[^\\d.]", ""));
            expectedNumOfResults = Math.min(availableResults, expectedNumOfResults);
        }

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

    public void verifyEmptyPageScreenVisible() {
        Assert.assertTrue(isElementPresent(emptyResultsIndicator), "Empty result screen should show");
    }

    public void gotoNextPage() {
        clickElement(nextPageBtn);
        waitUntilElementPresent(pageResultSize);
    }

    public void verifyCurrentHighlightedPage(int expectedPage) {
        Assert.assertEquals(getText(hightlightedPageIcon), String.valueOf(expectedPage), "page incorrect");
    }
}
