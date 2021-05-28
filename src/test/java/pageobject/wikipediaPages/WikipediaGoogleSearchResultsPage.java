package pageobject.wikipediaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.abstractPage.AbstractPage;

public class WikipediaGoogleSearchResultsPage extends AbstractPage {

    @FindBy(xpath = "(.//div[@class='tF2Cxc'])[1]")
    private WebElement firstSearchResultLink;

    public WikipediaGoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String searchResultsForWikipediaPageURL() {
        return driver.getCurrentUrl();
    }

    public String searchFirstLinkName() {
    return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", firstSearchResultLink);
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
        firstSearchResultLink.submit();
        return this;
    }
}