package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DressesPage {

    final static int WAIT_TIME_IN_SECONDS = 30;
    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By newsFilterLocator = By.xpath("//div[@class='filter-item filter-view__item--news']/div/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");
    WebDriver driver;

    public DressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
    }

    public void chooseNews(){
        WebElement newsFiler = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(newsFilterLocator));
        newsFiler.click();
    }

    public void applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
    }

}
