package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
   // private WebDriverWait webDriverWait;


    public BasePage(WebDriver driver){
        this.driver = driver;
    //    this.webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

 //   public void waitFor (By byFinder){
 //       webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(byFinder, 0));
 //   }

    public void waitForVisibility(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

    }

}
