package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PantsPage extends AbstractPage {
    static final By pantsItemLocator = By.xpath("//ul[@class='grid-container']/li[5]/div");
    public PantsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openItem(){
        WebElement pantsItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pantsItemLocator));
        pantsItem.click();
        logger.info("Item page opened");
        return new ItemPage(driver);
    }
}
