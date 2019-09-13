package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {

    @FindBy(className = "fb-filter-bar")
    private WebElement filterBox;
    @FindBy(xpath = "//*[@class='fb-price-list']//*[@class='fb-price']")
    private WebElement productPrices;
    @FindBy(xpath = "//*[@class='pod-item']")
    private WebElement productContainer;

    private By productList = By.className("section__pod-top");
    private By priceListInternet = By.xpath("//*[@class='fb-price-list']//p[contains(text(),'(Internet)')]");
    private By filterContainer = By.xpath("//*[@class='fb-filter_container']");
    private By priceFilterContainer = By.xpath("//*[@class='content-text-verticalFilter']");
    private By priceFilterTag = By.xpath("//div[@class='fb-form__label--selections']");

    public SearchPage() {
        super();
    }

    /**
     * This method selects the price filter from the filter types
     * and select a range to apply the filter
     * @param range refers to the limits of the price filter to apply
     */
    public void priceFilter( String range) {
        searchFilter("Precio", filterContainer);
        searchFilter(range,priceFilterContainer);
    }

    /**
     * This method search a specific filter form the ones located on the page
     * @param filterType refers to the name of the filter to search
     */
    private void searchFilter(String filterType, By xpath) {
        driverHelper.waitForVisibility(filterBox, 10);
        List<WebElement> filters = driver.findElements(xpath);
        WebElement filterSelected = null;
        int i = 0;
        while (i < filters.size()) {
            if (filters.get(i).getText().contains(filterType)) {
                filterSelected = filters.get(i);
            }
            i++;
        }
        if (filterSelected != null) {
            filterSelected.click();
        }
    }

    /**
     * This method checks that the products in a page are in between a specific price range
     * @param from refers the start of the range to check
     * @param to refers the end of the range to check
     * @return the return the result of the check
     */
    public boolean isPartOfPriceList(double from, double to){
        driverHelper.waitForVisibility(productContainer, 10);
        List<WebElement> pricesList = driver.findElements(priceListInternet);
        int i = 0;
        boolean response = true;
        while (i < pricesList.size()) {
            double price = Double.valueOf(pricesList.get(i)
                    .getText().split(" ")[1]);
            if (from > price|| price > to) {
                response = false;
                break;
            }
            i++;
        }
        return response;
    }
    /**
     * This method selects a random product from the page
     */
    public void selectRandomProduct(){
        List<WebElement> productsList = driver.findElements(productList);
        Random random = new Random();
        int productNumber = random.nextInt(productsList.size());
        productsList.get(productNumber).click();
    }
}