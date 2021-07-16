package stepdefinitions;

import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.googlePages.GoogleHomePage;
import pageobject.wikipediaPages.WikipediaGoogleSearchResultsPage;

import static org.testng.Assert.assertTrue;

public class GoogleStepDefinitions {
    @Given("I opened Google home page")
    public void iOpenedGoogleHomePage() {
        new GoogleHomePage(DriverSingleton.getDriver()).openGooglePage();
    }

    @When("I searched {string}")
    public void iSearchedWikipedia(String term) {
        new GoogleHomePage(DriverSingleton.getDriver()).searchForTerms(term);
    }

    @Then("I can see {string} home page address on the search result page")
    public void iCanSeeWikipediaHomePageAddressOnTheSearchResultPage(String wikipediaGoogleSearchExpectedResult) {
        String wikipediaGoogleSearchActualResult = new WikipediaGoogleSearchResultsPage(DriverSingleton.getDriver()).searchFirstLinkName();
        assertTrue(wikipediaGoogleSearchActualResult.contains(wikipediaGoogleSearchExpectedResult), "Google search result page does not contain 'wikipedia.org' text");
    }
}