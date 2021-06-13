package pageobject.jQuerySortablePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JquerySortablePage extends BasePage {
    private static final String JQUERY_SORTABLE_PAGE_URL = "https://jqueryui.com/sortable/#placeholder";

    @FindBy(css = "#content > iframe")
    private WebElement sortableListFrame;

    @FindBy(css = "#sortable > li:nth-child(1)")
    private WebElement firstSortableElement;

    @FindBy(css = "#sortable > li:nth-child(2)")
    private WebElement secondSortableElement;

    @FindBy(css = "#menu-top > li:nth-child(8) > a")
    private WebElement jQueryAboutSection;

//    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
//    private List<WebElement> sortableList;


    public JquerySortablePage(WebDriver driver) {
        super(driver);
    }

    public JquerySortablePage openJquerySortablePage() {
        openPage(JQUERY_SORTABLE_PAGE_URL);

        return this;
    }

    public String firstSortableElementText() {
        driver.switchTo().frame(sortableListFrame);
        highlightElement(secondSortableElement);
        dragAndDropElementByCoordinates(firstSortableElement);

        return firstSortableElement.getText();
    }

    public String jQueryAboutSectionText() {
        clickJqueryAboutSection(jQueryAboutSection);

        return jQueryAboutSection.getText();
    }
}