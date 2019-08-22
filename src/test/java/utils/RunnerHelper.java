package utils;

import cucumber.api.java.AfterStep;
import cucumber.api.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunnerHelper {

    public static WebDriver driver;

    public static void initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("www.google.com");
    }


    public static void closeDriver(){
        driver.quit();
    }

    public static WebDriver getDriver (){
        return driver;
    }
}
