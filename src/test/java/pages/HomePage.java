package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverHelper;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "header-login-modal")
    private WebElement optionLogin;

    @FindBy(id = "emailAddress")
    private WebElement userInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='Button__main__1NDc9 Button__green__1fhy5']")
    private WebElement loginButton;

    @FindBy (className = "Login__body__wb-dH")
    private WebElement loginPopUp;

    @FindBy (xpath = "//*[@class='fb-masthead-login__name re-design-cl__name']")
    private WebElement loginMessage;

    @FindBy (className = "Login__message__3fDqw")
    private WebElement errorLoginMessage;

    @FindBy (xpath = "//*[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']")
    private WebElement logoutMessage;
    
    @FindBy (className = "fb-filter-header__log-out")
    private WebElement logoutLink;

    public void clickOnLoginLink (){
        optionLogin.click();
        DriverHelper.waitForVisibility(loginPopUp, 2);
    }

    public void enterCredentials(String userEmail, String userPassword) {
        userInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        loginButton.click();
    }

    public String getAccountMessage (WebElement element){
        DriverHelper.waitForVisibility(element,10);
        return element.getText();
   }

    public String getLoginMessage (){
       return getAccountMessage(loginMessage);
    }

    public String getLogoutMessage (){
        return getAccountMessage(logoutMessage);
    }

    public String getErrorLoginMessage (){
        return getAccountMessage(errorLoginMessage);
    }

    public void clickOnLogoutLink (){
        optionLogin.click();
        DriverHelper.waitForVisibility(optionLogin, 10);
        logoutLink.click();

    }
}

