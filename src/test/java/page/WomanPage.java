package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WomanPage {
    //public static final String HOMEPAGE_URL = "https://www.bershka.com/by";

    static final int WAIT_TIME_IN_SECONDS = 30;

    static final By brandLocator = By.className("brand-logo");

    WebDriver driver;

    public WomanPage(WebDriver driver){
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

    public DressesPage openDressesPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Платья']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new DressesPage(driver);
    }

    public HatsPage openHatsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Головные уборы']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new HatsPage(driver);
    }

    public BlazersPage openBlazersPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Пиджаки']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new BlazersPage(driver);
    }

}
