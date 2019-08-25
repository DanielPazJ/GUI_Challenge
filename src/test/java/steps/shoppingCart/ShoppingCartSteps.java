package steps.shoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.Configuration;
import helpers.DriverHelper;

public class ShoppingCartSteps {

    private WebDriver driver;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps () {
        this.driver = DriverHelper.driver;
        this.productPage = new ProductPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        driver.get(Configuration.getProperties("productpage"));

    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addToShoppingCart();
    }

    @Given("I have a product in my shopping cart")
    public void iHaveAProductInMyShoppingCart() {
        iAmInAProductPage();
        iAddTheProductToTheCart();
    }

    @When("I delete the product")
    public void iDeleteTheProduct() {
       driver.get(Configuration.getProperties("bagpage"));
       shoppingCartPage.deleteProduct();
    }

}
