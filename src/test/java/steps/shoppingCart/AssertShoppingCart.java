package steps.shoppingCart;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AssertShoppingCart {

    private WebDriver driver;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    public AssertShoppingCart() {
        this.driver = DriverHelper.driver;
        this.productPage = new ProductPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Then("I should see a pop up with the confirmation")
    public void iShouldSeeAPopUpWithTheConfirmation() {
        assertThat("Wrong Message", productPage.getShoppingCartMessage(),
                equalTo(Configuration.getProperties("shopping.cart.message")));
    }

    @Then("I should see a message saying that my cart is empty")
    public void iShouldSeeAMessageSayingThatMyCartIsEmpty() {
        assertThat("Wrong Message",shoppingCartPage.shoppingCartEmptyMessage(),
                equalTo(Configuration.getProperties("shopping.cart.empty.message")));
    }
}
