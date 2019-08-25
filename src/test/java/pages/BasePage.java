package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverHelper;

public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessage(WebElement element){
        DriverHelper.waitForVisibility(element,10);
        return element.getText();
   }
}
