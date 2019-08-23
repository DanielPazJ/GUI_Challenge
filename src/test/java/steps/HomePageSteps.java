package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import utils.DataHelper;
import utils.DriverHelper;


public class HomePageSteps {

    private WebDriver driver;

    public HomePageSteps () {
        this.driver = DriverHelper.driver;
    }

    //private DataHelper dataHelper = new DataHelper();

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage(){
        driver.get(DataHelper.getProperties("homepage"));
        HomePage homePage = new HomePage(driver);
    }
}
