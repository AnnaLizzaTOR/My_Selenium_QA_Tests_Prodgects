package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        glue = "StepDefinition",
        features = {"src/test/resources/features"},
        format = {"pretty",
                "json:target/cucumber.json",
                "html:target/reports-pretty/"}
)
public class cucumberTestRunner extends AbstractTestNGCucumberTests {

}
