package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']")
    private WebElement shoppingCartMessage;

    public ProductPage() {
        super();
    }

    public void addToShoppingCart(){
        driverHelper.waitForVisibility(cartButton, 10);
        cartButton.click();
        driverHelper.waitForVisibility(shoppingCartMessage, 10);
    }

    public String getShoppingCartMessage (){
        return getMessage(shoppingCartMessage);
    }
}
