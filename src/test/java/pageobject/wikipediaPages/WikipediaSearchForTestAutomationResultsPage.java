package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import pageobject.abstractPage.AbstractPage;

public class WikipediaSearchForTestAutomationResultsPage extends AbstractPage {
    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver) {
        super(driver);
    }

    public String wikipediaSearchResultPageTitle() {
        return driver.getTitle();
    }
}