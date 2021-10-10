package helpers;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class FEUtils {

    WebDriver driver;

    public void openUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void closeDriver() {
        driver.close();
        driver.quit();
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
