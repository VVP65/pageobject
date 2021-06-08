package pageobject.wikipediaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.abstractPage.BasePage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WikipediaHomePage extends BasePage {
    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://en.wikipedia.org";

    @FindBy(name = "search")
    private WebElement wikipediaSearchInput;

    @FindBy(xpath = "//div[contains(@id,'dyk')]//img")
    public WebElement screenshotOfTheFirstDYKSectionElement;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public WikipediaHomePage openWikipediaHomePage() {
        openPage(WIKIPEDIA_HOMEPAGE_URL);

        return this;
    }

    public String wikipediaHomePageTitle() {
        return driver.getTitle();
    }

    public WikipediaSearchForTestAutomationResultsPage wikipediaSearchForTerms(String searchWikiTerm) {
        wikipediaSearchInput.sendKeys(searchWikiTerm);
        wikipediaSearchInput.submit();

        return new WikipediaSearchForTestAutomationResultsPage(driver);
    }

    public int getImageWidthForScreenshotOfTheFirstDYKSectionElement() throws IOException {
        WebElement element = screenshotOfTheFirstDYKSectionElement;
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);
        ImageIO.write(screenshot.getImage(), "jpg", new File("target\\ElementScreenshot.jpg"));

        return screenshotOfTheFirstDYKSectionElement.getSize().getWidth();
    }
}