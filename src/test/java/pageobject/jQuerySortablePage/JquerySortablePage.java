package pageobject.jQuerySortablePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

import java.util.List;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";
    protected static final int X_OFF_SET = 0;
    protected static final int Y_OFF_SET = 283;
    protected static final int Y_OFF_DELTA = 44;

    @FindBy(css = "#content > iframe")
    private WebElement sortableListFrame;

    @FindBy(css = "#sortable > li:nth-child(1)")
    private WebElement firstSortableElement;

    @FindBy(css = "#menu-top > li:nth-child(8) > a")
    private WebElement jQueryAboutSection;

    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
    public List<WebElement> sortableList;

    public JquerySortablePage(WebDriver driver) {
        super(driver);
    }

    public String jQuerySortablePageTitle() {
        return driver.getTitle();
    }

    public JquerySortablePage openJquerySortablePage() {
        openPage(JQUERY_SORTABLE_PAGE_URL);

        return this;
    }
    protected void clickJqueryAboutSectionElementWithJavaScriptExecutor() {
        JavascriptExecutor jsExec = ((JavascriptExecutor) driver);
        jsExec.executeScript("document.getElementById('alex-dovenmuehle').click()");
    }

    protected void dragAndDropElementByCoordinates() {
        for (int i = 0; i < sortableList.size() - 1; i++) {
            new Actions(driver).dragAndDropBy(sortableList.get(0), X_OFF_SET, Y_OFF_SET - i * Y_OFF_DELTA).build().perform();
            waiter(driver);
        }
    }

    public String firstSortableElementText() {
        driver.switchTo().frame(sortableListFrame);
        highlightElement(firstSortableElement);
        dragAndDropElementByCoordinates();

        return firstSortableElement.getText();
    }

    public String jQueryAboutSectionText() {
        clickJqueryAboutSection(jQueryAboutSection);
        clickJqueryAboutSectionElementWithJavaScriptExecutor();

        return jQueryAboutSection.getText();
    }
}