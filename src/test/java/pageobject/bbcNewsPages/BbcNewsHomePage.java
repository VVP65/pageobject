package pageobject.bbcNewsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

public class BbcNewsHomePage extends BasePage {
    private static final String BBC_NEWS_HOMEPAGE_URL = "https://www.bbc.com/news";
    private static final String HTTPS_BBC_NEWS_HOMEPAGE_URL = "testdata.https.bbc.news.homepage.url";
    private static final String HTTP_BBC_NEWS_HOMEPAGE_URL = "testdata.http.bbc.news.homepage.url";


    @FindBy(xpath = ".//input[@id='orb-search-q']")
    private WebElement bbcNewsSearchInput;

    @FindBy(xpath = ".//button[@id='orb-search-button']")
    private WebElement bbcNewsSearchButton;

    public BbcNewsHomePage(WebDriver driver) {
        super(driver);
    }

    public BbcNewsHomePage openBbcNewsHomePage() {
        openPage(BBC_NEWS_HOMEPAGE_URL);

        return this;
    }

    public BbcNewsSearchResultsPage searchForTerms(String searchTerm) {
        bbcNewsSearchInput.sendKeys(searchTerm);
        bbcNewsSearchButton.submit();

        return new BbcNewsSearchResultsPage(driver);
    }
}