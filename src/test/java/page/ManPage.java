package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManPage extends AbstractPage {
    static final By brandLocator = By.className("brand-logo");
    static final By searchLocator = By.className("search-bar");
    static final By searchInputLocator = By.xpath("//input[@name='search']");

    public ManPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ManPage hoverLogo(){
        WebElement hoverableLogo = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandLocator)).get(0);
        new Actions(driver)
                .moveToElement(hoverableLogo)
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Logo hovered");
        return this;
    }

    public BaseClothesPage openBaseClothes(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Базовый гардероб']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened BaseClothes Page");
        return new BaseClothesPage(driver);
    }

    public SneakersPage openSneakers(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Кеды']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened Sneakers Page");
        return new SneakersPage(driver);
    }

    public PantsPage openPantsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Брюки']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened Pants Page");
        return new PantsPage(driver);
    }

    public CoatsPage openCoatsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Куртки и пальто']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened Coats Page");
        return new CoatsPage(driver);
    }

    public ManPage openSearch(){
        CustomDelay(5);
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchLocator));
        searchButton.click();
        logger.info("Opened search");
        return this;
    }

    public SearchResultsPage setSearchQuery(String query){
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Search query set");
        return new SearchResultsPage(driver);
    }



}
