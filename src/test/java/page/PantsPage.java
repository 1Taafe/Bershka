package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PantsPage {
    WebDriver driver;

    final static int WAIT_TIME_IN_SECONDS = 30;
    static final By pantsItemLocator = By.xpath("//ul[@class='grid-container']/li[5]/div");
    public PantsPage(WebDriver driver){
        this.driver = driver;
    }

    public ItemPage openItem(){
        WebElement pantsItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pantsItemLocator));
        pantsItem.click();
        return new ItemPage(driver);
    }
}
