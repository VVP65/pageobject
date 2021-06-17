package pageobject.jQuerySortablePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

import java.util.List;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";
    private static final int X_OFF_SET = 0;
    private static final int Y_OFF_SET = 283;
    private static final int Y_OFF_DELTA = 44;

    @FindBy(xpath = ".//iframe[@class='demo-frame']")
    private WebElement sortableListFrame;

    @FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")
    private WebElement firstSortableElement;

    @FindBy(xpath = ".//a[@href='https://jqueryui.com/about/']")
    private WebElement jQueryAboutSection;

    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
    private List<WebElement> sortableList;

    public JquerySortablePage(WebDriver driver) {
        super(driver);
    }

    public JquerySortablePage openJquerySortablePage() {
        openPage(JQUERY_SORTABLE_PAGE_URL);

        return this;
    }

    protected void clickJqueryAboutSectionElementWithJavaScriptExecutor() {
        JavascriptExecutor jsExec = ((JavascriptExecutor) driver);
        jsExec.executeScript("document.getElementById('alex-dovenmuehle').click()");
    }

    public JquerySortablePage dragAndDropSortableListElementsWithCoordinates() {
        for (int i = 0; i < sortableList.size() - 1; i++) {
            dragAndDropElementWithCoordinates(sortableList.get(0), X_OFF_SET, Y_OFF_SET - i * Y_OFF_DELTA);
        }

        return this;
    }

    public JquerySortablePage highlightSortablePageElement() {
        driver.switchTo().frame(sortableListFrame);
        waitForElementVisibility(firstSortableElement);
        highlightElement(firstSortableElement);

        return this;
    }

    public String getFirstSortableElementText() {
        dragAndDropSortableListElementsWithCoordinates();

        return firstSortableElement.getText();
    }

    public String jQueryAboutSectionText() {
        clickWebElementUsingActions(jQueryAboutSection);
        clickJqueryAboutSectionElementWithJavaScriptExecutor();

        return jQueryAboutSection.getText();
    }
}