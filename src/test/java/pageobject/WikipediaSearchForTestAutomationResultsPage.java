package pageobject;

import org.openqa.selenium.WebDriver;

public class WikipediaSearchForTestAutomationResultsPage extends AbstractPage {
    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver, String searchWikiTerm) {
        super(driver);
    }

    public String wikipediaSearchResultPageTitle() {
        return driver.getTitle();
    }
}
