package pages;

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

    public HomePage() {
        super();
    }

    /**
     * This method click the login link to visualize the associated pop up
     */

    private void clickOnLoginLink(){
        optionLogin.click();
        driverHelper.waitForVisibility(loginPopUp, 2);
    }

    /**
     * This method fill the fields associated with login credentials
     * @param loginData refers to the data that permit the login
     */

    public void enterLoginCredentials(Map<String, String> loginData) {
        clickOnLoginLink();
        userInput.clear();
        userInput.sendKeys(loginData.get("Email"));
        passwordInput.clear();
        passwordInput.sendKeys(loginData.get("Password"));
        loginButton.click();
    }

    /**
     * This method gets the message associated with login
     * @return the message
     */
    public String getLoginMessage (){
        return getMessage(loginMessage).split(",")[0];
    }
    /**
     * This method exist to get the message associated with an error in the login
     *  @return the message
     */
    public String getLoginErrorMessage (){
        return getMessage(errorLoginMessage);
    }
    /**
     * This method exist to get the message associated with doing a logout
     * @return the message
     */
    public String getLogoutMessage (){
        return getMessage(logoutMessage).split("\\n")[0];
    }
    /**
     * This method exist to do a logout
     */
    public void logout(){
        optionLogin.click();
        driverHelper.waitForVisibility(logoutLink, 10);
        logoutLink.click();
    }
    /**
     * This method permits the access to the registration page from the homepage
     * @return a register page
     */
    public RegisterPage registration(){
        clickOnLoginLink();
        resgitrationLink.click();
        return new RegisterPage();
    }
    /**
     * This method permit to search a product from the home page
     * @param product to search
     */
    public void searchProduct( String product){
        searchBar.sendKeys(product);
        searchButton.click();
    }
}

