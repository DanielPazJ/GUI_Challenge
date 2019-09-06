package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;

public class CommonSteps {

    private WebDriver driver;
    private DriverHelper driverHelper;
    private HomePage homePage;

    public CommonSteps() {
        this.driver = Hook.driver;
        this.driverHelper = new DriverHelper(driver);
        this.homePage = new HomePage(driver);
    }

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage(){
        driverHelper.openPage("homePage");
    }

    @And("I search for ([^\"]*)")
    public void iSearchFor(String product) {
        homePage.searchProduct(product);
    }
}
