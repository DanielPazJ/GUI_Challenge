package steps.login;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.Hook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ValidLoginSteps {

    private WebDriver driver;

    public ValidLoginSteps () {
        this.driver = Hook.driver;
    }

    @Then("I should be signed in")
    public void IShouldBeSignedIn (){
        HomePage homePage = new HomePage(driver);
        assertThat("", homePage.getLoginMessage(), containsString("David"));
        //assertThat("Name does not match",homePage.getLoginMessage(), equalTo("Bienvenid@,\nDavid"));
    }
}
