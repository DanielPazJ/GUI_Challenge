package runner;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
        features = "src/test/resources/features"
)
public class Runner {

}