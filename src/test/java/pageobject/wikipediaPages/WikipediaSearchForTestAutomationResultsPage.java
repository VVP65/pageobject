package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import pageobject.basePage.BasePage;

public class WikipediaSearchForTestAutomationResultsPage extends BasePage {
    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver) {
        super(driver);
    }

    public String wikipediaSearchResultPageTitle() {
        return driver.getTitle();
    }
}