package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class BaseClothesPage {

    private final By jeansLocator = By.xpath("//button[text()='Джинсы']");
    final static int WAIT_TIME_IN_SECONDS = 30;
    WebDriver driver;

    public BaseClothesPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean openJeansPage(){
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("iFrameResizer0")));
        driver.switchTo().frame(iframe);
        //System.out.println(driver.getPageSource());
        WebElement jeansButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
               .until(ExpectedConditions.presenceOfElementLocated(jeansLocator));
        jeansButton.click();
        return true;
    }

}
