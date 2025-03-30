package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Home extends HomePageBase {

    @FindBy(id = "nav-hamburger-menu")
    private ExtendedWebElement hamburgerMenuButton;

    public Home(WebDriver driver) {
        super(driver);
    }

    @Override
    public HamburgerMenu getHamburgerMenu() {
        return openHamburgerMenu();
    }

    public HamburgerMenu openHamburgerMenu() {
        hamburgerMenuButton.click();
        return new HamburgerMenu(driver);
    }
}
