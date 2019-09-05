package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Configuration;

public class DriverHelper {

    public WebDriver driver;

    public DriverHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitForVisibility(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriver getDriver (){
        return driver;
    }

    public void openPage (String page){
        driver.get(Configuration.getProperties(page));
    }
}
