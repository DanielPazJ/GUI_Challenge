package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;

import static org.hamcrest.MatcherAssert.assertThat;

public class LogoutSteps {

    private WebDriver driver;
    private HomePage homePage;

    public LogoutSteps () {
        this.driver = Hook.driver;
        this.homePage = new HomePage(driver);
    }

    @And("I logout")
    public void iLogout() {
        homePage.logout();
    }

    @Then("I should see in the homepage the message {string}")
    public void iShouldSeeInTheHomepageTheMessage(String message) {
        assertThat("Wrong message",homePage.getLogoutMessage(), CoreMatchers.equalTo(message));
    }
}
