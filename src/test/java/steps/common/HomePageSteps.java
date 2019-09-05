package steps.common;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import steps.Hook;
import utils.Configuration;



public class HomePageSteps {

    private WebDriver driver;

    public HomePageSteps () {
        this.driver = Hook.driver;
    }

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage(){
        driver.get(Configuration.getProperties("homePage"));
    }
}
