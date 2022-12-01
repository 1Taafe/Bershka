package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HatsPage {

    final static int WAIT_TIME_IN_SECONDS = 20;
    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By yellowFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[10]/div/div/button");
    static final By blackFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[4]/div/div/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");

    WebDriver driver;
    public HatsPage(WebDriver driver){
        this.driver = driver;
    }

    public void openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
    }

    public void chooseColors(){
        WebElement yellowFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(yellowFilterLocator));
        yellowFilter.click();

        WebElement blackFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(blackFilterLocator));
        blackFilter.click();
    }

    public void applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
    }
}
