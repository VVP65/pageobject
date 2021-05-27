package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.abstractPage.AbstractPage;

public class WikipediaHomePage extends AbstractPage {
    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://ru.wikipedia.org";

    @FindBy(name = "search")
    private WebElement wikipediaSearchInput;

    @FindBy(xpath = "//div[contains(@id,'dyk')]//img")
    private WebElement screenshotOfTheFirstDYKSectionElement;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public WikipediaHomePage openWikipediaHomePage() {
        openPage(WIKIPEDIA_HOMEPAGE_URL);

        return this;
    }

    public WikipediaSearchForTestAutomationResultsPage wikipediaSearchForTerms(String searchWikiTerm) {
        wikipediaSearchInput.sendKeys(searchWikiTerm);
        wikipediaSearchInput.click();

        return new WikipediaSearchForTestAutomationResultsPage(driver);
    }

    public int getImageWidthForScreenshotOfTheFirstDYKSectionElement() {
        return screenshotOfTheFirstDYKSectionElement.getSize().getWidth();
    }
}