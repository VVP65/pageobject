package pageobject.jQuerySortablePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";

    @FindBy(xpath = ".//iframe[@class='demo-frame']")
    private WebElement sortableListFrame;

    @FindBy(css = "#sortable > li:nth-child(1)")
    private WebElement firstSortableElement;

    @FindBy(css = "#sortable > li:nth-child(2)")
    private WebElement secondSortableElement;

    public JquerySortablePage(WebDriver driver) {
        super(driver);
    }

    public JquerySortablePage openJquerySortablePage() {
        openPage(JQUERY_SORTABLE_PAGE_URL);

        return this;
    }

    public String jQuerySortablePageResult() {
        driver.switchTo().frame(sortableListFrame);
        JavascriptExecutor javascript = ((JavascriptExecutor) driver);
        javascript.executeScript("arguments[0].style.border='3px solid green'", secondSortableElement);
        new Actions(driver).dragAndDropBy(firstSortableElement, 8, 100).build().perform();

        return firstSortableElement.getText();
    }
}