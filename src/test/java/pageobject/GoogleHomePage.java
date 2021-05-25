package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends AbstractPage {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }
    private static final String GOOGLE_HOMEPAGE_URL = "https://google.com";

    @FindBy(name = "q")
    private WebElement googleSearchInput;

    @FindBy(xpath = "//*[@class='iblpc']")
    private WebElement googleSearchButton;

    public GoogleHomePage openGooglePage(){
        openPage(GOOGLE_HOMEPAGE_URL);
        return this;
    }

    public WikipediaGoogleSearchResultsPage searchForTerms(String searchTerm) {
        //openPage(GOOGLE_HOMEPAGE_URL);
        googleSearchInput.sendKeys(searchTerm);
        googleSearchButton.click();
        return new WikipediaGoogleSearchResultsPage(driver, searchTerm);
    }
}
