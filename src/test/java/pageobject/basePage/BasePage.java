package pageobject.basePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int TIME_OUT_SECONDS = 20;
    protected static final int X_OFF_SET = 8;
    protected static final int Y_OFF_SET = 100;

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

    protected void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        waiter(driver);
    }

    protected void highlightElement(WebElement element) {
        JavascriptExecutor javascript = ((JavascriptExecutor) driver);
        javascript.executeScript("arguments[0].style.border='3px solid green'", element);
    }

    protected void clickJqueryAboutSectionWithJavaScriptExecutor() {
        JavascriptExecutor jsExec = ((JavascriptExecutor) driver);
        jsExec.executeScript("document.getElementById('alex-dovenmuehle').click()");
    }

    protected void dragAndDropElementByCoordinates(WebElement element) {
        new Actions(driver).dragAndDropBy(element, X_OFF_SET, Y_OFF_SET).build().perform();
    }

    protected void clickJqueryAboutSection(WebElement element) {
        new Actions(driver).click(element).build().perform();
    }
}