package steps.login;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;
import utils.ConfigurationHelper;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps () {
        this.driver = Hook.driver;
    }

    @When("I sign in with valid credentials$")
    public void ISignInWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLoginLink();
        //homePage.enterCredentials("ejemplo@ejemplo.com","Test1234");
        homePage.enterCredentials(ConfigurationHelper
            .getProperties("user.email"),ConfigurationHelper.getProperties("user.password"));

    }
}
