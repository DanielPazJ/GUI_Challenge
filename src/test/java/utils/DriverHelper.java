package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {

    public static WebDriver driver;

    public static void initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //driver.get(DataHelper.getProperties("homepage"));

    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void waitForVisibility(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

    }

    public static WebDriver getDriver (){
        return driver;
    }
}
