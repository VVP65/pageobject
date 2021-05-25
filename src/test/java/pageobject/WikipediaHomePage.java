package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaHomePage extends AbstractPage {
    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://ru.wikipedia.org";

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    private WebElement wikipediaSearchInput;

    @FindBy(xpath = "//div[contains(@id,'dyk')]//img")
    private WebElement screenshotOfTheFirstDYKSectionElement;

    public WikipediaHomePage openWikipediaHomePage() {
        openPage(WIKIPEDIA_HOMEPAGE_URL);
        return this;
    }

    public WikipediaSearchForTestAutomationResultsPage wikipediaSearchForTerms(String searchWikiTerm) {
        //openPage(WIKIPEDIA_HOMEPAGE_URL);
        wikipediaSearchInput.sendKeys(searchWikiTerm);
        wikipediaSearchInput.click();
        return new WikipediaSearchForTestAutomationResultsPage(driver, searchWikiTerm);
    }
    public int getImageWidthForScreenshotOfTheFirstDYKSectionElement() {
        return screenshotOfTheFirstDYKSectionElement.getSize().getWidth();
    }
}
