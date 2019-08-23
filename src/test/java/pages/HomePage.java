package pages;

import Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy (xpath = "//*[@class='fb-masthead-login__name re-design-cl__name']//strong")
    private WebElement loginMessage;

    @FindBy (className = "Login__body__wb-dH")
    private WebElement loginPopUp;

    //private By loginPopUp = By.xpath("//*[@class='Login__body__wb-dH']//input");
    //private By loginMessag = By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']");

    public void clickOnLoginLink (){
        optionLogin.click();
        waitForVisibility(loginPopUp, 2);
     //   waitFor(loginPopUp);

    }

    public void enterCredentials(String userEmail, String userPassword) {
        userInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        loginButton.click();
    }

    public String getLoginMessage (){
        waitForVisibility(loginMessage, 5);
        return loginMessage.getText();
    }
}

