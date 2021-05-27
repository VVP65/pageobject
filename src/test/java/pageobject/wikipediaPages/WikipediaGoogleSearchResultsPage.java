package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.abstractPage.AbstractPage;

public class WikipediaGoogleSearchResultsPage extends AbstractPage {

    @FindBy(xpath = "(.//a[contains(@accesskey,'z')])[1]")
    private WebElement firstSearchResultLink;

    public WikipediaGoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String searchResultsForWikipediaPageURL() {

        return driver.getCurrentUrl();
    }

    public String wikipediaPageTitle() {
        return driver.getTitle();
    }

    public int wikipediaTitleLength() {
        return driver.getTitle().length();
    }

    public int searchResultLength() {
        return driver.getTitle().length();
    }

    public WikipediaGoogleSearchResultsPage openFirstSearchResultLink() {
        firstSearchResultLink.click();
        return this;
    }
}