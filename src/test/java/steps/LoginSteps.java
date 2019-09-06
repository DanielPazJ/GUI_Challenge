package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginSteps {


    private WebDriver driver;
    private HomePage homePage;

    public LoginSteps () {
        this.driver = Hook.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I login with credentials")
    public void iLoginWithCredentials(Map<String, String> loginData) {
        homePage.enterLoginCredentials(loginData);
}
    @Then("I should see the message: ([^\"]*)")
    public void iShouldSeeTheMessage(String message){
        assertThat("Name does not match",homePage.getLoginMessage(),equalTo(message));
    }

    @Then("I should see a login error message that says: ([^\"]*)")
    public void iShouldSeeALoginErrorMessageThatSays(String message) {
        assertThat("Name does not match",homePage.getLoginErrorMessage(),equalTo(message));
    }
}
