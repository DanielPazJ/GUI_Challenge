package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helpers.DriverHelper;
import helpers.DriverFactory;

class BasePage {

    DriverHelper driverHelper;
    WebDriver driver;

    BasePage(){
       this.driver = DriverFactory.getDriver();
        driverHelper = new DriverHelper();
        PageFactory.initElements(driver, this);
    }

    String getMessage(WebElement element){
        driverHelper.waitForVisibility(element,10);
        return element.getText();
   }
}
