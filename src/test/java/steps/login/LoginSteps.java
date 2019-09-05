package steps.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginSteps {


    private WebDriver driver;
    private HomePage homePage;

    public LoginSteps () {
        this.driver = Hook.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        homePage.clickOnLoginLink();
        homePage.enterCredentials(Configuration.getProperties("valid.user.email"),
                Configuration.getProperties("valid.user.password"));
    }


    @Then("I should be logged in")
    public void IShouldBeSignedIn (){
        assertThat("Name does not match", homePage.getLoginMessage(),
                equalTo(Configuration.getProperties("login.message")));
    }

    @When("I login with invalid email and password credentials")
    public void iLoginWithInvalidEmailAndPasswordCredentials() {
        homePage.clickOnLoginLink();
        homePage.enterCredentials(Configuration.getProperties("invalid.user.email"),
                Configuration.getProperties("invalid.user.password"));
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
        assertThat("Wrong message", homePage.getErrorLoginMessage(),
                equalTo(Configuration.getProperties("login.error.message")));
    }
}
