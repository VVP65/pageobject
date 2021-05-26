package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaGoogleSearchResultsPage extends AbstractPage {
    public WikipediaGoogleSearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
    }

    private String searchTerm;

    @FindBy(xpath = "(.//a[contains(@accesskey,'z')])[1]")
    private WebElement firstSearchResultLink;

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