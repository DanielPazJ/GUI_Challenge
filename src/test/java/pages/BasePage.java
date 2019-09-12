package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helpers.DriverHelper;
import helpers.DriverFactory;

public class BasePage {

    protected DriverHelper driverHelper;
    protected WebDriver driver;
//    private DriverFactory driverFactory;

    BasePage(){
       this.driver = DriverFactory.getDriver();
        driverHelper = new DriverHelper();
        PageFactory.initElements(driver, this);
    }

    public String getMessage(WebElement element){
        driverHelper.waitForVisibility(element,10);
        return element.getText();
   }
}
