package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import utils.ConfigurationHelper;


public class HomePageSteps {

    private WebDriver driver;

    public HomePageSteps () {
        this.driver = Hook.getDriver();
    }

    private ConfigurationHelper configurationHelper = new ConfigurationHelper();

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage(){

        //driver.get(configurationHelper.getProperties("homepage"));
        HomePage homePage = new HomePage(driver);
    }
}
