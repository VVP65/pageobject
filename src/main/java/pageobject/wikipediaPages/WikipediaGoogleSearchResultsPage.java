package pageobject.wikipediaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

public class WikipediaGoogleSearchResultsPage extends BasePage {
    @FindBy(xpath = "(.//div[@class='tF2Cxc'])[1]")
    private WebElement firstSearchResultLink;

    public WikipediaGoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String searchFirstLinkName() {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", firstSearchResultLink);
    }

    public int searchResultLength() {
        return driver.getTitle().length();
    }
}