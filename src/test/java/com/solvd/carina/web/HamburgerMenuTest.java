package com.solvd.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HamburgerMenuTest implements IAbstractTest {

    @Test
    public void testSelectProductFromCategories() {

        Home homePage = new Home(getDriver());
        homePage.open();
        pause(8);

        SoftAssert softAssert = new SoftAssert();


        HamburgerMenu hamburgerMenu = homePage.openHamburgerMenu();
        softAssert.assertTrue(hamburgerMenu.isMenuOpened(), "Hamburger menu did not open");


        BestSellersPage bestSellersPage = (BestSellersPage) hamburgerMenu.selectCategory("Best Sellers");
        softAssert.assertTrue(bestSellersPage.isPageOpened(), "Best Sellers page did not open");


        ProductPage bestSellerProduct = bestSellersPage.selectProduct(1);
        softAssert.assertTrue(bestSellerProduct.isPageOpened(), "Product page from Best Sellers did not open");
        bestSellerProduct.addToBasket();
        softAssert.assertTrue(bestSellerProduct.verifyProductAddedToBasket(),
                "Product was not added to basket from Best Sellers");


        getDriver().navigate().back();
        pause(4);


        hamburgerMenu = homePage.openHamburgerMenu();
        softAssert.assertTrue(hamburgerMenu.isMenuOpened(), "Hamburger menu did not reopen");


        BookPage booksPage = (BookPage) hamburgerMenu.selectCategory("Books");
        softAssert.assertTrue(booksPage.isPageOpened(), "Books page did not open");


        ProductPage bookProduct = booksPage.selectProduct(1);
        softAssert.assertTrue(bookProduct.isPageOpened(), "Product page from Books did not open");
        bookProduct.addToBasket();
        softAssert.assertTrue(bookProduct.verifyProductAddedToBasket(),
                "Product was not added to basket from Books");


        softAssert.assertAll();
    }
}
