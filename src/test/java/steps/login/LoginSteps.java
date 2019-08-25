package steps.login;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Configuration;
import helpers.DriverHelper;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;

    public LoginSteps () {
        this.driver = DriverHelper.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {

        homePage.clickOnLoginLink();
        homePage.enterCredentials(Configuration.getProperties("valid.user.email"),
                Configuration.getProperties("valid.user.password"));
    }

    @When("I login with invalid email and password credentials")
    public void iLoginWithInvalidEmailAndPasswordCredentials() {
        homePage.clickOnLoginLink();
        homePage.enterCredentials(Configuration.getProperties("invalid.user.email"),
                Configuration.getProperties("invalid.user.password"));
    }
}
