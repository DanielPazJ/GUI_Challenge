package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataHelper;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

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

    public void fillRegister(String dataField){

        if(dataField.equals("name")){
            userName.sendKeys(DataHelper.getProperties("register.name"));
        }else if(dataField.equals("fathersLastName")){
            fathersLastName.sendKeys(DataHelper.getProperties("register.lastname"));
        }else if(dataField.equals("mothersLastName")){
            mothersLastName.sendKeys(DataHelper.getProperties("register.lastname"));
        }else if(dataField.equals("email")){
            email.sendKeys(DataHelper.getProperties("register.email"));
        }else if(dataField.equals("password")){
            password.sendKeys(DataHelper.getProperties("register.password"));
        }else if(dataField.equals("confirmPassword")) {
            confirmPassword.sendKeys(DataHelper.getProperties("register.password"));
        }else if(dataField.equals("idNumber")){
            idNumber.sendKeys(DataHelper.getProperties("register.idNumber"));
        }else if(dataField.equals("cellphone")){
            cellphone.sendKeys(DataHelper.getProperties("register.cellphone"));
        }
    }

    public void registerGender (){

        if(DataHelper.getProperties("register.gender").equals("Female")){
            femaleGender.click();
        }else{
            maleGender.click();
        }
    }

    public void registerBirthday(){
        date.click();
        driver.findElement(By.xpath("//*[@id='day']//*[@value='"+DataHelper.getProperties("register.day")+"']")).click();
        month.click();
        driver.findElement(By.xpath("//*[@id='month']//*[@value='"+DataHelper.getProperties("register.month")+"']")).click();
        year.click();
        driver.findElement(By.xpath("//*[@id='year']//*[@value='"+DataHelper.getProperties("register.year")+"']")).click();
    }

    public void acceptConditions(){
        acceptTerms.click();
    }

    public void acceptRegistration (){
        registryButton.click();
    }

    public String cellphoneErrorMessage (){
       return getMessage(errorCellphoneMessage);
    }
}
