package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DressesPage extends AbstractPage{

    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By newsFilterLocator = By.xpath("//div[@class='filter-item filter-view__item--news']/div/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");

    public DressesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public DressesPage openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
        logger.info("Filters window opened");
        return this;
    }

    public DressesPage chooseNews(){
        WebElement newsFiler = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(newsFilterLocator));
        newsFiler.click();
        logger.info("Filter 'new clothes' selected");
        return this;
    }

    public DressesPage applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
        logger.info("Filters were applied");
        return this;
    }

}
