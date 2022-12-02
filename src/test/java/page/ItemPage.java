package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends AbstractPage {

    static final By sizeLLocator = By.xpath("//ul[@class='ui--size-dot-list']/li[4]/button");

    static final By size45Locator = By.xpath("//div[@class='size-selector-pdp']/div[2]/ul/li[7]/button");
    static final By sizeSLocator = By.xpath("//ul[@class='ui--size-dot-list']/li[2]/button");

    static final By findInStoreLocator = By.xpath("//div[@class='add-cart-group']/button");

    static final By regionInputLocator = By.id("location-input-address");

    static final By regionButtonLocator = By.xpath("//div[@class='abstract-modal store-availability-finder']/div/div[2]/button");
    static final By sizeHelpLocator = By.xpath("//div[@class='size-help']/div/button");
    static final By sizeHelp36Locator = By.xpath("//div[@class='size-guide__scroll']/ul/li[2]/button");

    static final By additionalItemLocator = By.xpath("//div[@class='swiper-wrapper']/div[4]/div");

    static final By sliderNextLocator = By.xpath("//div[@class='product-carousel']/div/button");

    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage sliderNext(){
        WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sliderNextLocator));
        nextButton.click();
        logger.info("Slider scrolled one time");
        return this;
    }
    public ItemPage openSizeHelper(){
        WebElement sizeHelper = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeHelpLocator));
        sizeHelper.click();
        logger.info("SizeHelper opened");
        return this;
    }

    public ItemPage chooseHelpSizes(){
        WebElement size36Button = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeHelp36Locator));
        size36Button.click();
        logger.info("Size 36 selected");
        return this;
    }

    public ItemPage choose45Size(){
        WebElement size45Button = (new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)))
                .until(ExpectedConditions.elementToBeClickable(size45Locator));
        size45Button.click();
        logger.info("Size 45 selected");
        return this;
    }

    public ItemPage chooseLSize(){
        WebElement sizeLButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeLLocator));
        sizeLButton.click();
        logger.info("Size L selected");
        return this;
    }

    public ItemPage chooseSSize(){
        WebElement sizeSButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeSLocator));
        sizeSButton.click();
        logger.info("Size S selected");
        return this;
    }

    public ItemPage findInStore(){
        WebElement findButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(findInStoreLocator));
        findButton.click();
        logger.info("FindInStore button pressed");
        return this;
    }

    public ItemPage setRegion(String region){
        WebElement regionInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(regionInputLocator));
        regionInput.sendKeys(region);
        logger.info("Region set");
        return this;
    }

    public ItemPage checkAvailability(){
        WebElement regionButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(regionButtonLocator));
        regionButton.click();
        logger.info("Availability checked");
        return this;
    }

    public ItemPage openAdditionalItem(){
        CustomDelay(5);
        WebElement additionalItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(additionalItemLocator));
        additionalItem.click();
        logger.info("Additional item page opened");
        return this;
    }

}
