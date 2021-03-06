package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.DriverHelper;
import pages.HomePage;

import java.io.IOException;

public class CommonSteps {

    private DriverHelper driverHelper;
    private HomePage homePage;

    public CommonSteps() {
        this.driverHelper = new DriverHelper();
        this.homePage = new HomePage();
    }

    @Given("I am in the Falabella homepage$")
    public void IAmInTheFalabellaHomepage() throws IOException {
        driverHelper.openPage("homePage");
    }

    @And("I search for ([^\"]*)")
    public void iSearchFor(String product) {
        homePage.searchProduct(product);
    }
}
