package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Configuration;

public class DriverHelper {

    private WebDriver driver;

    public DriverHelper(){
        this.driver = DriverFactory.getDriver();
    }

    public void waitForVisibility(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openPage (String page){
        driver.get(Configuration.getProperties(page));
    }
}
