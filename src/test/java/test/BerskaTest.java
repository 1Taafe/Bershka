package test;

import jdk.jfr.Description;
import page.*;
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
    @Description("Поиск новых платьев")
    public void BershkaTest4(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomanPage womanPage = homePage.chooseFemaleGender();
        womanPage.hoverLogo();
        DressesPage dressesPage = womanPage.openDressesPage();
        dressesPage.openFilters();
        dressesPage.chooseNews();
        dressesPage.applyFilters();
    }

    @Test
    @Description("Поиск мужских джинс из базовой коллекции(базового гардероба)")
    public void BershkaTest8(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.hoverLogo();
        BaseClothesPage baseClothesPage = manPage.openBaseClothes();
        baseClothesPage.openJeansPage();
    }

    @AfterMethod(alwaysRun = true)
    public void QuitDriver() throws Exception {
        Thread.sleep(5000);
        driver.quit();
        driver = null;
    }
}
