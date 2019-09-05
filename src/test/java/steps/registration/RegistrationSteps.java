package steps.registration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import helpers.DriverHelper;
import steps.Hook;
import utils.Configuration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RegistrationSteps {

    private HomePage homePage;
    private RegisterPage registerPage;

    public RegistrationSteps() {
        this.homePage = new HomePage(Hook.driver);
        this.registerPage = new RegisterPage(Hook.driver);
    }

    @When("I try to register$")
    public void iTryToRegister (){
        homePage.registration();
    }

    @And("I fill all the field except for ([^\"]*)")
    public void iFillAllTheFieldExceptFor(String data) {

        if (!data.equals("nombre") ) {
            registerPage.fillRegister("name");
        }
        if (!data.equals("apellido paterno")){
            registerPage.fillRegister("fathersLastName");
        }
        if (!data.equals("apellido materno")){
            registerPage.fillRegister("mothersLastName");
        }
        if (!data.equals("correo")){
            registerPage.fillRegister("email");
        }
        if (!data.equals("contraseña")){
            registerPage.fillRegister("password");
        }
        if (!data.equals("confirmar contraseña")){
            registerPage.fillRegister("confirmPassword");
        }
        if (!data.equals("número de cedula")){
            registerPage.fillRegister("idNumber");
        }
        if (!data.equals("celular")){
            registerPage.fillRegister("cellphone");
        }
        registerPage.registerGender();
        registerPage.registerBirthday();
        registerPage.acceptConditions();
    }

    @And("I try to save my data")
    public void iTryToSaveMyData() {
        registerPage.acceptRegistration();
    }

    @Then("I should see an error message")
    public void IShouldSeeAnErrorMessage(){
        assertThat("Wrong Message", registerPage.cellphoneErrorMessage(),
                equalTo(Configuration.getProperties("register.error.cellphone")));
    }
}
