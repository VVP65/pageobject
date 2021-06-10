package pageobject.jQuerySortablePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

import javax.swing.*;
import java.util.List;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";

    @FindBy(xpath = ".//iframe[@class='demo-frame']")
    private WebElement sortableListFrame;

    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
    private List<WebElement> sortableList;

    public JquerySortablePage(WebDriver driver) {
        super(driver);
    }

    public JquerySortablePage openJquerySortablePage() {
        openPage(JQUERY_SORTABLE_PAGE_URL);

        return this;
    }

    public String jQuerySortablePageResult() throws InterruptedException {
        driver.switchTo().frame(sortableListFrame);
        new Actions(driver).dragAndDrop(sortableList.get(0),sortableList.get(3)).build().perform();

        return sortableList.get(0).getText();
    }
}