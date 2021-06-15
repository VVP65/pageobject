package pageobject.jQuerySortablePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";

    @FindBy(css = "#content > iframe")
    private WebElement sortableListFrame;

    @FindBy(css = "#sortable > li:nth-child(1)")
    private WebElement firstSortableElement;

    @FindBy(css = "#menu-top > li:nth-child(8) > a")
    private WebElement jQueryAboutSection;

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