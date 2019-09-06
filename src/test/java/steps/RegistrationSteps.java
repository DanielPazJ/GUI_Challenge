package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import steps.Hook;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RegistrationSteps {

    private HomePage homePage;
    private RegisterPage registerPage;

    public RegistrationSteps() {
        this.homePage = new HomePage(Hook.driver);
        this.registerPage = new RegisterPage(Hook.driver);
    }

    @When("I try to register with the information")
    public void iTryToRegisterWithTheInformation (Map<String, String> registrationData){
        homePage.registration();
        registerPage.fillRegisterForm(registrationData);
    }

    @And("I try to save my data")
    public void iTryToSaveMyData() {
        registerPage.acceptRegistration();
    }

    @Then("I should see an error message that says: ([^\"]*)")
    public void IShouldSeeAnErrorMessageThatSays(String message){
        assertThat("Wrong Message", registerPage.cellphoneErrorMessage(), equalTo(message));
    }
}
