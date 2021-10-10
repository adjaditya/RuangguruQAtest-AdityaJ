package helpers.utils;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FEUtils {

    static WebDriver driver;

    public void initiateBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void closeBrowserSession() {
        if (driver != null) {
            driver.close();
        }
    }

    public List<WebElement> getElementsList (String locator) {
        By selectedLocator = getByLocator(locator);
        return driver.findElements(selectedLocator);
    }

    public WebElement getElement (String locator) {
        By selectedLocator = getByLocator(locator);
        return driver.findElement(selectedLocator);
    }

    public boolean isElementPresent(String locator) {
        return getElementsList(locator).size() > 0;
    }

    public void editInput(String locator, String input) {
        getElement(locator).clear();
        getElement(locator).sendKeys(input);
    }

    public void clickEnter(String locator) {
        getElement(locator).sendKeys(Keys.ENTER);
    }

    public void clickElement(String locator) {
        getElement(locator).click();
    }

    public void waitUntilElementPresent(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void printAllElementUnder(String locator) {
        System.out.println(getElement(locator).getAttribute("innerHTML"));

    }
//    PRIVATE METHODS---------------------------------------

    private By getByLocator(String locator) {
        int start = locator.indexOf("==");
        String locatorType = locator.substring(0, start).toLowerCase();
        String locatorValue = locator.substring(start + 2);

        switch (locatorType) {
            case "xpath":
                return By.xpath(locatorValue);

            default:
                Assert.fail("Invalid locator type: " + locatorType);
                return null;
        }
    }
}
