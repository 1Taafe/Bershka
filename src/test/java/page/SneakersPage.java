package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SneakersPage {

    final static int WAIT_TIME_IN_SECONDS = 30;
    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");
    static final By whiteFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[1]/div/div/button");
    static final By size44Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[6]/div/div/button");
    static final By size45Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[7]/div/div/button");
    static final By size46Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[8]/div/div/button");
    //
    static final By price120Locataor = By.xpath("//div[@class='filter-list filter-view__item--price']/ul/li[3]/div/div/button");

    static final By sneakersItemLocator = By.xpath("//ul[@class='grid-container']/li[4]/div/a");

    WebDriver driver;
    public SneakersPage(WebDriver driver){
        this.driver = driver;
    }

    public void openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
    }

    public void chooseColors(){
        WebElement whiteFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(whiteFilterLocator));
        whiteFilter.click();
    }

    public void chooseSizes(){
        WebElement size44Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size44Locator));
        size44Filter.click();

        WebElement size45Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size45Locator));
        size45Filter.click();

        WebElement size46Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size46Locator));
        size46Filter.click();
    }

    public void choose45Size(){
        WebElement size45Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size45Locator));
        size45Filter.click();
    }

    public void choosePrice(){
        WebElement priceFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(price120Locataor));
        priceFilter.click();
    }

    public void applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
    }

    public ItemPage openItem(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement sneakersItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sneakersItemLocator));
        sneakersItem.click();
        return new ItemPage(driver);
    }

}
