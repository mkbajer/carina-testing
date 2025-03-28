package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        super.open();
    }

    // Returns the Hamburger Menu
    public abstract HamburgerMenu getHamburgerMenu();


}
