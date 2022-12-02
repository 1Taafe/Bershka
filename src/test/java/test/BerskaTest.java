package test;

import jdk.jfr.Description;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
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

    @Test(description = "Поиск мужских белых пар кед размером 44-46 ценой до 110 рублей")
    public void BershkaTest1(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        SneakersPage sneakersPage = manPage.openSneakers();
        sneakersPage.openFilters();
        sneakersPage.chooseColors();
        sneakersPage.chooseSizes();
        sneakersPage.choosePrice();
        sneakersPage.applyFilters();
    }

    @Test(description = "Поиск товара \"Футболка Red Hot Chili Peppers\"(мужская) размера L в магазинах Минска")
    public void BershkaTest2(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.openSearch();
        SearchResultsPage searchResultsPage = manPage.setSearchQuery("футболка red hot chili peppers");
        ItemPage itemPage = searchResultsPage.openFoundItem();
        itemPage.chooseLSize();
        itemPage.findInStore();
        itemPage.setRegion("Минск");
        itemPage.checkAvailability();
    }

    @Test(description = "Поиск розовых женских пиджаков oversize размером M и L ценой до 200 рублей")
    public void BershkaTest3(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomanPage womanPage = homePage.chooseFemaleGender();
        womanPage.hoverLogo();
        BlazersPage blazersPage = womanPage.openBlazersPage();
        blazersPage.openFilters();
        blazersPage.chooseType();
        blazersPage.chooseColors();
        blazersPage.chooseSizes();
        blazersPage.choosePrice();
        blazersPage.applyFilters();
    }

    @Test(description = "Поиск новых платьев")
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

    @Test(description = "Определение замеров 36 размера мужских брюк карго с широкими штанинами и констрастной строчкой")
    public void BershkaTest5(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.hoverLogo();
        PantsPage pantsPage = manPage.openPantsPage();
        ItemPage itemPage = pantsPage.openItem();
        itemPage.openSizeHelper();
        itemPage.chooseHelpSizes();
    }

    @Test(description = "Найти дополняющую образ сумку для мужского пальто комфортного кроя")
    public void BershkaTest6(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.hoverLogo();
        CoatsPage coatsPage = manPage.openCoatsPage();
        ItemPage itemPage = coatsPage.openItem();
        itemPage.sliderNext();
        itemPage.openAdditionalItem();
    }

    @Test(description = "Поиск товара \"Толстовка оверсайз с высоким воротником\"(мужская) размера S в магазинах Гродно")
    public void BershkaTest7(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.openSearch();
        SearchResultsPage searchResultsPage = manPage.setSearchQuery("толстовка оверсайз с высоким воротником");
        ItemPage itemPage = searchResultsPage.openFoundItem();
        itemPage.chooseSSize();
        itemPage.findInStore();
        itemPage.setRegion("Гродно");
        itemPage.checkAvailability();
    }

    @Test(description = "Поиск мужских джинс из базовой коллекции(базового гардероба)")
    public void BershkaTest8(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.hoverLogo();
        BaseClothesPage baseClothesPage = manPage.openBaseClothes();
        baseClothesPage.openJeansPage();
    }

    @Test(description = "Поиск черных и желтых женских головных уборов")
    public void BershkaTest9(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomanPage womanPage = homePage.chooseFemaleGender();
        womanPage.hoverLogo();
        HatsPage hatsPage = womanPage.openHatsPage();
        hatsPage.openFilters();
        hatsPage.chooseColors();
        hatsPage.applyFilters();
    }

    @Test(description = "Поиск белых мужских кед размера 45")
    public void BershkaTest10(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseMaleGender();
        manPage.hoverLogo();
        SneakersPage sneakersPage = manPage.openSneakers();
        sneakersPage.openFilters();
        sneakersPage.chooseColors();
        sneakersPage.choose45Size();
        sneakersPage.applyFilters();
        ItemPage itemPage = sneakersPage.openItem();
    }

    @AfterMethod(alwaysRun = true)
    public void QuitDriver() throws Exception {
        Thread.sleep(1000);
        driver.quit();
        driver = null;
    }
}
