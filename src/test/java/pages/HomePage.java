package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class HomePage extends BasePage{

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

    @FindBy (xpath = "//*[@class='fb-filter-header__log-out']")
    private WebElement logoutLink;

    @FindBy (xpath = "//*[@class='Login__createAccount__38c2o']/a")
    private WebElement resgitrationLink;

    @FindBy(className = "fb-masthead-search__box__input")
    private WebElement searchBar;

    @FindBy (xpath = "//*[@class='fb-masthead__util-bar__link fb-masthead-search__box__button-search']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void clickOnLoginLink(){
        optionLogin.click();
        driverHelper.waitForVisibility(loginPopUp, 2);
    }

    public void enterLoginCredentials(Map<String, String> loginData) {
        clickOnLoginLink();
        userInput.sendKeys(loginData.get("Email"));
        passwordInput.sendKeys(loginData.get("Password"));
        loginButton.click();
    }

    public String getLoginMessage (){
        return getMessage(loginMessage).split(",")[0];
    }

    public String getLoginErrorMessage (){
        return getMessage(errorLoginMessage);
    }

    public String getLogoutMessage (){
        return getMessage(logoutMessage).split("\\n")[0];
    }

    public void logout(){
        optionLogin.click();
        driverHelper.waitForVisibility(logoutLink, 10);
        logoutLink.click();
    }

    public RegisterPage registration(){
        clickOnLoginLink();
        resgitrationLink.click();
        return new RegisterPage(driver);
    }

    public void searchProduct( String product){
        searchBar.sendKeys(product);
        searchButton.click();
    }
}

