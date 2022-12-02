package test;

import page.*;
import org.testng.annotations.Test;
import service.RegionCreator;

public class BerskaTest extends CommonConditions {
    @Test(description = "Поиск мужских белых пар кед размером 44-46 ценой до 110 рублей")
    public void BershkaTest1(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .hoverLogo()
                .openSneakers()
                .openFilters()
                .chooseColors()
                .chooseSizes()
                .choosePrice()
                .applyFilters();
    }

    @Test(description = "Поиск товара \"Футболка Red Hot Chili Peppers\"(мужская) размера L в магазинах Минска")
    public void BershkaTest2(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .openSearch()
                .setSearchQuery("футболка red hot chili peppers")
                .openFoundItem()
                .chooseLSize()
                .findInStore()
                .setRegion(RegionCreator.withCredentialsFromProperty())
                .checkAvailability();
    }

    @Test(description = "Поиск розовых женских пиджаков oversize размером M и L ценой до 200 рублей")
    public void BershkaTest3(){
        new HomePage(driver).openPage()
                .chooseFemaleGender()
                .hoverLogo()
                .openBlazersPage()
                .openFilters()
                .chooseType()
                .chooseColors()
                .chooseSizes()
                .choosePrice()
                .applyFilters();
    }

    @Test(description = "Поиск новых платьев")
    public void BershkaTest4(){
        new HomePage(driver).openPage()
                .chooseFemaleGender()
                .hoverLogo()
                .openDressesPage()
                .openFilters()
                .chooseNews()
                .applyFilters();
    }

    @Test(description = "Определение замеров 36 размера мужских брюк карго с широкими штанинами и констрастной строчкой")
    public void BershkaTest5(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .hoverLogo()
                .openPantsPage()
                .openItem()
                .openSizeHelper()
                .chooseHelpSizes();
    }

    @Test(description = "Найти дополняющую образ сумку для мужского пальто комфортного кроя")
    public void BershkaTest6(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .hoverLogo()
                .openCoatsPage()
                .openItem()
                .sliderNext()
                .openAdditionalItem();
    }

    @Test(description = "Поиск товара \"Толстовка оверсайз с высоким воротником\"(мужская) размера S в магазинах Гродно")
    public void BershkaTest7(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .openSearch()
                .setSearchQuery("толстовка оверсайз с высоким воротником")
                .openFoundItem()
                .chooseSSize()
                .findInStore()
                .setRegion("Гродно")
                .checkAvailability();
    }

    @Test(description = "Поиск мужских джинс из базовой коллекции(базового гардероба)")
    public void BershkaTest8(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .hoverLogo()
                .openBaseClothes()
                .openJeansPage();
    }

    @Test(description = "Поиск черных и желтых женских головных уборов")
    public void BershkaTest9(){
        new HomePage(driver).openPage()
                .chooseFemaleGender()
                .hoverLogo()
                .openHatsPage()
                .openFilters()
                .chooseColors()
                .applyFilters();
    }

    @Test(description = "Поиск белых мужских кед размера 45")
    public void BershkaTest10(){
        new HomePage(driver).openPage()
                .chooseMaleGender()
                .hoverLogo()
                .openSneakers()
                .openFilters()
                .chooseColors()
                .choose45Size()
                .applyFilters()
                .openItem();
    }

}
