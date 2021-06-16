package pageobject.googlePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.wikipediaPages.WikipediaGoogleSearchResultsPage;
import pageobject.basePage.BasePage;

public class GoogleHomePage extends BasePage {
    private static final String GOOGLE_HOMEPAGE_URL = "https://google.com";

    @FindBy(name = "q")
    private WebElement googleSearchInput;

    @FindBy(xpath = "//*[@class='iblpc']")
    private WebElement googleSearchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage openGooglePage() {
        openPage(GOOGLE_HOMEPAGE_URL);

        return this;
    }

    public WikipediaGoogleSearchResultsPage searchForTerms(String searchTerm) {
        googleSearchInput.sendKeys(searchTerm);
        googleSearchButton.submit();

        return new WikipediaGoogleSearchResultsPage(driver);
    }
}