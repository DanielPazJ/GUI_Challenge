package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.Hook;
import utils.Configuration;

import java.util.Map;

public class RegisterPage extends BasePage {

    @FindBy(id = "user")
    private WebElement userName;

    @FindBy(id = "apellidopaterno")
    private WebElement fathersLastName;

    @FindBy(id = "apellidomaterno")
    private WebElement mothersLastName;

    @FindBy(id = "mail")
    private WebElement email;

    @FindBy(id = "clave1")
    private WebElement password;

    @FindBy(id = "clave2")
    private WebElement confirmPassword;

    @FindBy(id = "cedula_colombia")
    private WebElement idNumber;

    @FindBy(xpath = "//*[@value='male']")
    private WebElement maleGender;

    @FindBy(xpath = "//*[@value='female']")
    private WebElement femaleGender;

    @FindBy(id = "day")
    private WebElement date;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "celular")
    private WebElement cellphone;

    @FindBy(id = "agreelegaleId")
    private WebElement acceptTerms;

    @FindBy(id = "boton_Ar")
    private WebElement registryButton;

    @FindBy(id = "mensajeCelVacio")
    private WebElement errorCellphoneMessage;

    public RegisterPage() {
        super();
    }

    public void fillRegisterForm (Map<String, String> registrationData){

            userName.sendKeys(registrationData.get("First Name"));
            fathersLastName.sendKeys(registrationData.get("Father Last Name"));
            mothersLastName.sendKeys(registrationData.get("Mother Last Name"));
            email.sendKeys(registrationData.get("Email Address"));
            password.sendKeys(registrationData.get("Password"));
            confirmPassword.sendKeys(registrationData.get("Confirm Password"));
            idNumber.sendKeys(registrationData.get("ID Number"));
            cellphone.sendKeys(registrationData.get("Cellphone"));
            registerBirthday(registrationData.get("Birthday date"));
            registerGender(registrationData.get("Gender"));
    }

    private void registerGender(String gender){
        if(gender.equals("Female")){
            femaleGender.click();
        }else{
            maleGender.click();
        }
    }

    private void registerBirthday(String birthday){
        String[] birthdayDate = birthday.split("/");
        date.click();
        driver.findElement(By.xpath("//*[@id='day']//*[@value='" + birthdayDate[0] + "']")).click();
        month.click();
        driver.findElement(By.xpath("//*[@id='month']//*[@value='" + birthdayDate[1] + "']")).click();
        year.click();
        driver.findElement(By.xpath("//*[@id='year']//*[@value='" + birthdayDate[2] +"']")).click();
    }

    public void acceptRegistration (){
        acceptTerms.click();
        registryButton.click();
    }

    public String cellphoneErrorMessage (){
       return getMessage(errorCellphoneMessage);
    }
}
