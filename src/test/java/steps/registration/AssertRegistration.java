package steps.registration;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AssertRegistration {

    private WebDriver driver;
    private RegisterPage registerPage;

    public AssertRegistration() {
        this.driver = DriverHelper.driver;
        this.registerPage = new RegisterPage(driver);
    }

    @Then("I should see an error message")
    public void IShouldSeeAnErrorMessage(){
        assertThat("Wrong Message", registerPage.cellphoneErrorMessage(),
                equalTo(Configuration.getProperties("register.error.cellphone")));
    }
}
