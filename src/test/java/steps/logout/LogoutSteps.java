package steps.logout;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import helpers.DriverHelper;
import steps.Hook;
import utils.Configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LogoutSteps {

    private WebDriver driver;
    private HomePage homePage;

    public LogoutSteps () {
        this.driver = Hook.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I click logout")
    public void iClickLogout() {
        homePage.clickOnLogoutLink();
    }

    @Then("I should be signed out")
    public void iShouldBeSignedOut() {
        assertThat("Wrong Message", homePage.getLogoutMessage(),
                equalTo(Configuration.getProperties("logout.message")));
    }
}
