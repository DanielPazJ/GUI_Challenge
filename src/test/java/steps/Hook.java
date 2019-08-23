package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigurationHelper;

public class Hook {

    public static WebDriver driver;

    @Before
    public static void initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //driver.get(ConfigurationHelper.getProperties("homepage"));
    }

    @After
    public static void closeDriver(){
        driver.quit();
    }

   // public static WebDriver getDriver (){
   //     return driver;
   // }
}
