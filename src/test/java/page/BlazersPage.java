package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlazersPage {

    final static int WAIT_TIME_IN_SECONDS = 20;
    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By pinkFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[7]/div/div/button");

    static final By sizeMLocator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[4]/div/div/button");
    static final By sizeLLocator = By.xpath("//div[@class='filter-list filter-view__item--size']/ul/li[6]/div/div/button");
    static final By price200Locator = By.xpath("//div[@class='filter-list filter-view__item--price']/ul/li[6]/div/div/button");

    static final By oversizeLocator = By.xpath("//div[@class='filter-list filter-view__item--tipology']/ul/li[1]/div/div/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");

    WebDriver driver;
    public BlazersPage(WebDriver driver){
        this.driver = driver;
    }

    public void openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
    }

    public void chooseColors(){
        WebElement pinkFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pinkFilterLocator));
        pinkFilter.click();
    }

    public void chooseSizes(){
        WebElement sizeMFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeMLocator));
        sizeMFilter.click();

        WebElement sizeLFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeLLocator));
        sizeLFilter.click();
    }

    public void choosePrice(){
        WebElement price200Filter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(price200Locator));
        price200Filter.click();
    }

    public void chooseType(){
        WebElement oversizeFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(oversizeLocator));
        oversizeFilter.click();
    }

    public void applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
    }
}

