package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoatsPage extends AbstractPage {
    static final By coatItemLocator = By.xpath("//ul[@class='grid-container']/li[15]/div");
    public CoatsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openItem(){
        CustomDelay(5);
        WebElement coatItem = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(coatItemLocator));
        coatItem.click();
        logger.info("Item page opened");
        return new ItemPage(driver);
    }
}
