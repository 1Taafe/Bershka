package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    public static final String HOMEPAGE_URL = "https://www.bershka.com/by";
    private final By selectGenderLocator = By.className("gender-selector__container");

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public ManPage chooseMaleGender(){
        WebElement gender = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectGenderLocator)).get(1);
        gender.click();
        logger.info("Male page opened");
        return new ManPage(driver);
    }

    public WomanPage chooseFemaleGender(){
        WebElement gender = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectGenderLocator)).get(0);
        gender.click();
        logger.info("Female page opened");
        return new WomanPage(driver);
    }

}
