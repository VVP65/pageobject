package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import pageobject.abstractPage.AbstractPage;

public class WikipediaSearchForTestAutomationResultsPage extends AbstractPage {
    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver, String searchWikiTerm) {
        super(driver);
    }

    public String wikipediaSearchResultPageTitle() {
        return driver.getTitle();
    }
}