package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.hamcrest.CoreMatchers;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LogoutSteps {

    private HomePage homePage;

    public LogoutSteps () {
        this.homePage = new HomePage();
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
