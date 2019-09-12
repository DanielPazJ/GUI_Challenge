package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public DriverFactory(){
    }

    public static WebDriver getDriver(){
        if (driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
