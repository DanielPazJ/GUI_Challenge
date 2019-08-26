package steps.common;

import cucumber.api.java.en.Given;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import utils.Configuration;
import helpers.DriverHelper;


public class HomePageSteps {

    private WebDriver driver;

    public HomePageSteps () {
        this.driver = DriverHelper.driver;
    }

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage(){
        driver.get(Configuration.getProperties("homepage"));
        HomePage homePage = new HomePage(driver);
    }
}
