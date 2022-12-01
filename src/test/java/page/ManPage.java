package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManPage {
    //public static final String HOMEPAGE_URL = "https://www.bershka.com/by";

    static final int WAIT_TIME_IN_SECONDS = 20;

    static final By brandLocator = By.className("brand-logo");
    static final By searchLocator = By.className("search-bar");
    static final By searchInputLocator = By.xpath("//input[@name='search']");

    WebDriver driver;

    public ManPage(WebDriver driver){
        this.driver = driver;
    }

    public void hoverLogo(){
        WebElement hoverableLogo = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandLocator)).get(0);
        new Actions(driver)
                .moveToElement(hoverableLogo)
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    public BaseClothesPage openBaseClothes(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Базовый гардероб']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new BaseClothesPage(driver);
    }

    public SneakersPage openSneakers(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Кеды']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new SneakersPage(driver);
    }

    public PantsPage openPantsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Брюки']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new PantsPage(driver);
    }

    public CoatsPage openCoatsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Куртки и пальто']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new CoatsPage(driver);
    }

    public void openSearch(){
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchLocator));
        searchButton.click();
    }

    public SearchResultsPage setSearchQuery(String query){
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }



}
