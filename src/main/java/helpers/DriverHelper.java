package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Configuration;

import java.io.IOException;

public class DriverHelper {

    private WebDriver driver;

    public DriverHelper(){
        this.driver = DriverFactory.getDriver();
    }

    /**
     * This method makes the driver wait until a element is visible
     * @param element refers to the element to wait for
     * @param time refers to how much time the driver waits for the element
     */
    public void waitForVisibility(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openPage (String page) throws IOException {
        driver.get(Configuration.getProperties(page));
    }
}
