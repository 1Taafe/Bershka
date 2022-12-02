package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {

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
    static final int WAIT_TIME_IN_SECONDS = 30;
    WebDriver driver;

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    public void sliderNext(){
        WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sliderNextLocator));
        nextButton.click();
    }
    public void openSizeHelper(){
        WebElement sizeHelper = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeHelpLocator));
        sizeHelper.click();
    }

    public void chooseHelpSizes(){
        WebElement size36Button = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeHelp36Locator));
        size36Button.click();
    }

    public void choose45Size(){
        try{
            WebElement size45Button = (new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)))
                    .until(ExpectedConditions.elementToBeClickable(size45Locator));
            size45Button.click();
        }
        catch (Exception ex){
            WebElement size45Button = driver.findElement(size45Locator);
            size45Button.click();
        }
    }

    public void chooseLSize(){
        WebElement sizeLButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeLLocator));
        sizeLButton.click();
    }

    public void chooseSSize(){
        WebElement sizeSButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeSLocator));
        sizeSButton.click();
    }

    public void findInStore(){
        try{
            WebElement findButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(findInStoreLocator));
            findButton.click();
        }
        catch (Exception ex){
            WebElement findButton = driver.findElement(findInStoreLocator);
            findButton.click();
        }

    }

    public void setRegion(String region){
        WebElement regionInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(regionInputLocator));
        regionInput.sendKeys(region);
    }

    public void checkAvailability(){
        WebElement regionButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(regionButtonLocator));
        regionButton.click();
    }

    public void openAdditionalItem(){
        WebElement additionalItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(additionalItemLocator));
        additionalItem.click();
    }

}
