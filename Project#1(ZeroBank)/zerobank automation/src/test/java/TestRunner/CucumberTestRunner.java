package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        glue = "StepDefinition",
        features = {"src/test/resources/features"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
