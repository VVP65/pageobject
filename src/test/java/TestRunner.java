import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },
        glue = "stepdefinitions",
        features="src/test/resources"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}