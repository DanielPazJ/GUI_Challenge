package steps.filter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchPage;


public class FilterSteps {

    private WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;

    public FilterSteps() {
        this.driver = DriverHelper.driver;
        this.homePage = new HomePage(driver);
        this.searchPage = new SearchPage(driver);
    }

    @And("I search for ([^\"]*)")
    public void iSearchFor(String product) {
        homePage.searchProduct(product);
    }

    @When("I apply the filter for ([^\"]*) between ([^\"]*) and ([^\"]*)")
    public void iApplyTheFilterForPriceBetweenAnd(String filterType,String filterFrom, String filterTo) {
        String range = "$"+filterFrom+" - "+"$"+filterTo;
        searchPage.priceFilter(filterType, range);
    }


}
