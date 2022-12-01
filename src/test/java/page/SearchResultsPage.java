package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    static final By searchItemLocator = By.xpath("//ul[@class='grid-container']/li[2]/div");
    static final int WAIT_TIME_IN_SECONDS = 20;

    WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public ItemPage openFoundItem(){
        WebElement item = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchItemLocator));
        item.click();
        return new ItemPage(driver);
    }

}