package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WomanPage extends AbstractPage {
    static final By brandLocator = By.className("brand-logo");

    public WomanPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WomanPage hoverLogo(){
        WebElement hoverableLogo = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandLocator)).get(0);
        new Actions(driver)
                .moveToElement(hoverableLogo)
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Logo hovered");
        return this;
    }

    public DressesPage openDressesPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Платья']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened dresses page");
        return new DressesPage(driver);
    }

    public HatsPage openHatsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Головные уборы']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened hats page");
        return new HatsPage(driver);
    }

    public BlazersPage openBlazersPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Пиджаки']\")[0].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        logger.info("Opened blazers page");
        return new BlazersPage(driver);
    }

}
