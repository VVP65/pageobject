package stepdefinitions;

import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.bbcNewsPages.BbcNewsHomePage;
import pageobject.bbcNewsPages.BbcNewsSearchResultsPage;

import static org.testng.Assert.assertTrue;

public class BbcNewsStepDefinitions {
    @Given("I opened BBC News home page")
    public void iOpenedBbcNewsHomePage() {
        new BbcNewsHomePage(DriverSingleton.getDriver()).openBbcNewsHomePage();
    }

    @When("I searched {string} and open new page")
    public void iSearchedNews(String news) {
        new BbcNewsHomePage(DriverSingleton.getDriver()).searchForTerms(news);
    }

    @Then("I can see News page contains {string}")
    public void iCanSeeNewsPageContainsContent(String bbcNewsSearchExpectedResult) {
        String bbcNewsSearchActualResult = new BbcNewsSearchResultsPage(DriverSingleton.getDriver()).searchFirstLinkName();
        assertTrue(bbcNewsSearchActualResult.contains(bbcNewsSearchExpectedResult), "BBC News search result page does not contain correct text");
    }
}