package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends AbstractPage {

    static final By searchItemLocator = By.xpath("//ul[@class='grid-container']/li[2]/div");
    public SearchResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openFoundItem(){
        WebElement item = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchItemLocator));
        item.click();
        logger.info("Found item page opened");
        return new ItemPage(driver);
    }

}
