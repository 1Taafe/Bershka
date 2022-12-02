package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HatsPage extends AbstractPage{

    static final By filtersLocator = By.xpath("//ul[@class='order-grid-header']/li[2]/button");
    static final By yellowFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[10]/div/div/button");
    static final By blackFilterLocator = By.xpath("//div[@class='filter-list filter-view__item--color']/ul/li[4]/div/div/button");
    static final By applyButtonLocator = By.xpath("//button[@data-qa-anchor='seeResultBtn']");

    public HatsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HatsPage openFilters(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersLocator));
        filtersButton.click();
        logger.info("Filters window opened");
        return this;
    }

    public HatsPage chooseColors(){
        WebElement yellowFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(yellowFilterLocator));
        yellowFilter.click();
        logger.info("Color Yellow selected");

        WebElement blackFilter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(blackFilterLocator));
        blackFilter.click();
        logger.info("Color Black selected");
        return this;
    }

    public HatsPage applyFilters(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
        logger.info("Filters were applied");
        return this;
    }
}
