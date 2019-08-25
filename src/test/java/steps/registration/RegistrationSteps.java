package steps.registration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import helpers.DriverHelper;

public class RegistrationSteps {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    public RegistrationSteps() {
        this.driver = DriverHelper.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I try to register$")
    public void iTryToRegister (){
        this.registerPage = homePage.registration();
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
}
