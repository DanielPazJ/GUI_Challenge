package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
        features ="src/test/resources/features"
)
public class Runner {

}