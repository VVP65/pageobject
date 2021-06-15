package pageobject.basePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int TIME_OUT_SECONDS = 20;

    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
    public List<WebElement> sortableList;

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

    protected void clickJqueryAboutSectionElementWithJavaScriptExecutor() {
        JavascriptExecutor jsExec = ((JavascriptExecutor) driver);
        jsExec.executeScript("document.getElementById('alex-dovenmuehle').click()");
    }

    protected void dragAndDropElementByCoordinates() {
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(0)).build().perform();
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(1)).build().perform();
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(2)).build().perform();
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(3)).build().perform();
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(4)).build().perform();
        new Actions(driver).dragAndDrop(sortableList.get(6), sortableList.get(5)).build().perform();
    }

    protected void clickJqueryAboutSection(WebElement element) {
        new Actions(driver).click(element).build().perform();
    }
}