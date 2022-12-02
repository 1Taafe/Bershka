package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class BaseClothesPage extends AbstractPage {

    private final By jeansLocator = By.xpath("//button[text()='Джинсы']");

    public BaseClothesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openJeansPage(){
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("iFrameResizer0")));
        driver.switchTo().frame(iframe);
        WebElement jeansButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
               .until(ExpectedConditions.presenceOfElementLocated(jeansLocator));
        jeansButton.click();
        logger.info("Opened Jeans Page");
    }

}
