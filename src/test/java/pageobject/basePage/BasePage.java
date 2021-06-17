package pageobject.basePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int TIME_OUT_SECONDS = 20;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static void waiter(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
        wait.until(pageLoadCondition);
    }

    protected boolean waitForElementVisibility(WebElement element) {
        new WebDriverWait(driver, TIME_OUT_SECONDS).until(ExpectedConditions.visibilityOf(element));

        return element.isEnabled();
    }

    protected void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        waiter(driver);
    }

    protected BasePage highlightElement(WebElement element) {
        JavascriptExecutor javascript = ((JavascriptExecutor) driver);
        javascript.executeScript("arguments[0].style.border='3px solid green'", element);

        return this;
    }

    protected BasePage clickWebElementUsingActions(WebElement element) {
        new Actions(driver).click(element).build().perform();

        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected BasePage dragAndDropElementWithCoordinates(WebElement source, int xOffset, int yOffset) {
        new Actions(driver).dragAndDropBy(source, xOffset, yOffset).build().perform();

        return this;
    }
}