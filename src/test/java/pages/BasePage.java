package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helpers.DriverHelper;

public class BasePage {

    protected DriverHelper driverHelper;
    protected WebDriver driver;

    BasePage(WebDriver driver){
        driverHelper = new DriverHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMessage(WebElement element){
        driverHelper.waitForVisibility(element,10);
        return element.getText();
   }
}
