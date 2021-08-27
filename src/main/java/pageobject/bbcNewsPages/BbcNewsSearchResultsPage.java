package pageobject.bbcNewsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage.BasePage;

public class BbcNewsSearchResultsPage extends BasePage {
    @FindBy(xpath = "(.//div[contains(@class,'ssrcss-10kr542')])[1]")
    private WebElement firstBbcNewsSearchResultLink;

    public BbcNewsSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String searchFirstLinkName() {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", firstBbcNewsSearchResultLink);
    }

    public int bbcNewsSearchResultPageLength() {
        return driver.getTitle().length();
    }
}