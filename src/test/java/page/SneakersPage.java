package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SneakersPage extends AbstractPage {
    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");
    static final By whiteFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[1]/div/div/button");
    static final By size44Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[6]/div/div/button");
    static final By size45Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[7]/div/div/button");
    static final By size46Locator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[8]/div/div/button");
    //
    static final By price120Locator = By.xpath("//div[@class='filter-list filter-view__item--price']/ul/li[3]/div/div/button");

    static final By sneakersItemLocator = By.xpath("//ul[@class='grid-container']/li[4]/div/a");

    public SneakersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SneakersPage openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
        logger.info("Filters window opened");
        return this;
    }

    public SneakersPage chooseColors(){
        WebElement whiteFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(whiteFilterLocator));
        whiteFilter.click();
        logger.info("Colors selected");
        return this;
    }

    public SneakersPage chooseSizes(){
        WebElement size44Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size44Locator));
        size44Filter.click();
        logger.info("Size 44 selected");

        WebElement size45Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size45Locator));
        size45Filter.click();
        logger.info("Size 45 selected");

        WebElement size46Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size46Locator));
        size46Filter.click();
        logger.info("Size 46 selected");
        return this;
    }

    public SneakersPage choose45Size(){
        WebElement size45Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(size45Locator));
        size45Filter.click();
        logger.info("Size 45 selected");
        return this;
    }

    public SneakersPage choosePrice(){
        WebElement priceFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(price120Locator));
        priceFilter.click();
        logger.info("Price under 120 selected");
        return this;
    }

    public SneakersPage applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
        logger.info("Filters were applied");
        return this;
    }

    public ItemPage openItem(){
        CustomDelay(6);
        WebElement sneakersItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sneakersItemLocator));
        sneakersItem.click();
        logger.info("Item page opened");
        return new ItemPage(driver);
    }

}
