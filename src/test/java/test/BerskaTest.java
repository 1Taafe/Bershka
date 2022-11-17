package test;

import page.BaseClothesPage;
import page.HomePage;
import page.ManPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BerskaTest {
    WebDriver driver;
    @BeforeMethod

    public void InitializeDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void BershkaTest8(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseGender();
        manPage.hoverLogo();
        BaseClothesPage baseClothesPage = manPage.openBaseClothes();
        Assert.assertTrue(baseClothesPage.openJeansPage());
    }

    @AfterMethod(alwaysRun = true)
    public void QuitDriver() {
        driver.quit();
        driver = null;
    }
}
