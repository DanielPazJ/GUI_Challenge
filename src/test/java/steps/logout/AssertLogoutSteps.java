package steps.logout;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AssertLogoutSteps {

    private WebDriver driver;
    private HomePage homePage;
    public AssertLogoutSteps() {
        this.driver = DriverHelper.driver;
        this. homePage = new HomePage(driver);
    }

    @Then("I should be signed out")
    public void iShouldBeSignedOut() {
        assertThat("Wrong Message", homePage.getLogoutMessage(),
                equalTo(Configuration.getProperties("logout.message")));
    }
}
