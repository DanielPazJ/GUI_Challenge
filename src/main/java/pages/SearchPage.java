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

    public SearchPage() {
        super();
    }

    public void priceFilter(String filterType, String range) {
        searchFilter(filterType, filterContainer);
        searchFilter(range,priceFilterContainer);
    }

    private void searchFilter(String filterType, By xpath) {
        driverHelper.waitForVisibility(filterBox, 10);
        List<WebElement> filters = driver.findElements((xpath));
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

    public boolean verifyPriceList (double from, double to){
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

    public void selectProduct (){
        List<WebElement> productsList = driver.findElements(productList);
        Random rand = new Random();
        int productNumber = rand.nextInt(productsList.size());
        productsList.get(productNumber).click();
    }
}