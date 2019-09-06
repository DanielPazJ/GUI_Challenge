package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import steps.Hook;
import utils.Configuration;
import helpers.DriverHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingCartSteps {

    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private SearchPage searchPage;
    private DriverHelper driverHelper;

    public ShoppingCartSteps () {
        WebDriver driver = Hook.driver;
        this.driverHelper = new DriverHelper(driver);
        this.productPage = new ProductPage(driver);
        this.searchPage = new SearchPage(Hook.driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        driverHelper.openPage("productPage");
    }

    @And("I select a product to go to it is page")
    public void iSelectAProductToGoToItIsPage() {
        searchPage.selectProduct();
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addToShoppingCart();
    }

    @Then("I should see a pop up with the confirmation message: ([^\"]*)")
    public void iShouldSeeAPopUpWithTheConfirmationMessage(String message) {
        assertThat("Wrong Message", productPage.getShoppingCartMessage(),equalTo(message));
    }

    @Given("I am in the shopping cart page")
    public void iAmInTheShoppingCartPage() {
        driverHelper.openPage("bagPage");
    }

    @When("I delete the product")
    public void iDeleteTheProduct() {
        shoppingCartPage.deleteProduct();
    }

    @Then("I should that my cart is empty by the message: ([^\"]*)")
    public void iShouldThatMyCartIsEmptyByTheMessage(String message) {
        assertThat("Wrong Message",shoppingCartPage.shoppingCartEmptyMessage(),equalTo(message));
    }
}