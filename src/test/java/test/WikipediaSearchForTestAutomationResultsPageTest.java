package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.WikipediaHomePage;

public class WikipediaSearchForTestAutomationResultsPageTest extends BaseTest {
    public WikipediaSearchForTestAutomationResultsPageTest(WebDriver driver) {
        super(driver);
    }
    @Test
    public void searchForTestAutomationCheck(){

        String searchForTestAutomationSearch = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .wikipediaSearchForTerms("Test Automation")
                .wikipediaSearchResultPageTitle();

        Assert.assertTrue(searchForTestAutomationSearch.contains("Test Automation"));
        logger.info(String.format("Wikipedia search for Test Automation page result -  '%s'", searchForTestAutomationSearch));
    }
}