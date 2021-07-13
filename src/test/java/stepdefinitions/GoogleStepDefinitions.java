package stepdefinitions;

import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.googlePages.GoogleHomePage;
import pageobject.wikipediaPages.WikipediaGoogleSearchResultsPage;
import tests.BaseTest;

public class GoogleStepDefinitions extends BaseTest {
    @Given("I open Google home page")
    public void iOpenGoogleHomePage() {
        new GoogleHomePage(DriverSingleton.getDriver()).openGooglePage();
    }

    @When("^I search ([\\w ]+)$")
    public void iSearchWikipedia() {
        new GoogleHomePage(DriverSingleton.getDriver()).searchForTerms("Wikipedia");
    }

    @Then("^I can see ([\\w ]+) home page address on the search result page$")
    public void iCanSeeWikipediaHomePageAddressOnTheSearchResultPage(String actualResult) {
        String wikipediaGoogleSearchResult = new WikipediaGoogleSearchResultsPage(DriverSingleton.getDriver()).searchFirstLinkName();
        Assert.assertTrue(wikipediaGoogleSearchResult.contains(actualResult), "Google search result page does not contain 'wikipedia.org' text");
    }
}