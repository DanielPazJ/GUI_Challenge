package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helpers.DriverHelper;
import helpers.DriverFactory;

abstract class BasePage {

    DriverHelper driverHelper;
    WebDriver driver;


    BasePage(){
       this.driver = DriverFactory.getDriver();
        driverHelper = new DriverHelper();
        PageFactory.initElements(driver, this);
    }
    /**
     * This method exist to get the text that a Web element has
     * @param element of
     * @return the text of the element
     */
    String getMessage(WebElement element){
        driverHelper.waitForVisibility(element,10);
        return element.getText();
   }
}
