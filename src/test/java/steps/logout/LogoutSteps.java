package steps.logout;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverHelper;

public class LogoutSteps {

    private WebDriver driver;
    private HomePage homePage;

    public LogoutSteps () {
        this.driver = DriverHelper.driver;
        this.homePage = new HomePage(driver);
    }

    @When("I click logout")
    public void iClickLogout() {
        homePage.clickOnLogoutLink();
    }
}
