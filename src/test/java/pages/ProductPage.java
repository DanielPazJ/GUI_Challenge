package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helpers.DriverHelper;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']")
    private WebElement shoppingCartMessage;

    public void addToShoppingCart(){
        DriverHelper.waitForVisibility(cartButton, 10);
        cartButton.click();
        DriverHelper.waitForVisibility(shoppingCartMessage, 10);
    }

    public String getShoppingCartMessage (){
        return getMessage(shoppingCartMessage);
    }
}
