package steps.shoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.ShoppingCartPage;
import steps.Hook;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingCartSteps {

    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private DriverHelper driverHelper;

    public ShoppingCartSteps () {
        WebDriver driver = Hook.driver;
        this.driverHelper = new DriverHelper(driver);
        this.productPage = new ProductPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        driverHelper.openPage("productPage");
//       driver.get(Configuration.getProperties("productpage"));

    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addToShoppingCart();
    }

    @Then("I should see a pop up with the confirmation")
    public void iShouldSeeAPopUpWithTheConfirmation() {
        assertThat("Wrong Message", productPage.getShoppingCartMessage(),
                equalTo(Configuration.getProperties("shopping.cart.message")));
    }

    @Given("I have a product in my shopping cart")
    public void iHaveAProductInMyShoppingCart() {
        iAmInAProductPage();
        iAddTheProductToTheCart();
    }

    @When("I delete the product")
    public void iDeleteTheProduct() {
        driverHelper.openPage("bagPage");
//       driver.get(Configuration.getProperties("bagpage"));
       shoppingCartPage.deleteProduct();
    }

    @Then("I should see a message saying that my cart is empty")
    public void iShouldSeeAMessageSayingThatMyCartIsEmpty() {
        assertThat("Wrong Message",shoppingCartPage.shoppingCartEmptyMessage(),
                equalTo(Configuration.getProperties("shopping.cart.empty.message")));
    }
}
