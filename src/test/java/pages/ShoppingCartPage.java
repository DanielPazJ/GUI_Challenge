package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-product__action-list__item fb-product__action-list__item--delete js-product__action-list--delete']")
    private WebElement deleteLink;

    @FindBy(xpath =  "//*[@class='fb-order-status__empty-basket']")
    private WebElement shoppingCartEmptyMessage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteProduct(){
        driverHelper.waitForVisibility(deleteLink,10);
        deleteLink.click();
    }

    public String shoppingCartEmptyMessage(){
        driverHelper.waitForVisibility(shoppingCartEmptyMessage, 10);
        return getMessage(shoppingCartEmptyMessage).split(">>")[0];
    }



}