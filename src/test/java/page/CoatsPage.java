package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoatsPage {
    WebDriver driver;
    final static int WAIT_TIME_IN_SECONDS = 20;
    static final By coatItemLocator = By.xpath("//ul[@class='grid-container']/li[12]/div");
    public CoatsPage(WebDriver driver){
        this.driver = driver;
    }

    public ItemPage openItem(){
        WebElement coatItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(coatItemLocator));
        coatItem.click();
        return new ItemPage(driver);
    }
}
