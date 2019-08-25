package steps.login;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DataHelper;
import utils.DriverHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AssertLoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    public AssertLoginSteps() {
        this.driver = DriverHelper.driver;
        this.homePage = new HomePage(driver);
    }

    @Then("I should be logged in")
    public void IShouldBeSignedIn (){
        assertThat("Name does not match", homePage.getLoginMessage(),
                equalTo(DataHelper.getProperties("login.message")));
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
        assertThat("Wrong message", homePage.getErrorLoginMessage(),
                equalTo(DataHelper.getProperties("login.error.message")));
    }
}
