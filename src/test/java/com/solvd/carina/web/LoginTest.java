package com.solvd.carina.web;


import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test(description = "Verify that a user can log in to Amazon")
    public void testAmazonLogin() {

        Search homePage = new Search(getDriver());
        homePage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Amazon home page did not open");


        OpenSign loginPage = new OpenSign(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened");


        String testEmail = "testuser@example.com";
        String testPassword = "YourSecurePassword";
        loginPage.login(testEmail, testPassword);


        String greeting = homePage.getGreetingText();
        Assert.assertFalse(greeting.contains("Sign in"), "Login might have failed - still seeing 'Sign in' text.");

    }
}
