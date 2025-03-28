package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HamburgerMenu extends AbstractPage {

    // Container for the hamburger
    @FindBy(id = "hmenu-container")
    private ExtendedWebElement menuContainer;

    public HamburgerMenu(WebDriver driver) {
        super(driver);
    }

    // Checks if the hamburger menu is visible
    public boolean isMenuOpened() {
        return menuContainer.isVisible();
    }

    public AbstractPage selectCategory(String categoryName) {
        ExtendedWebElement categoryLink = findExtendedWebElement(
                By.xpath(".//a[normalize-space(text())='" + categoryName + "']")
        );
        categoryLink.click();
        if (categoryName.equalsIgnoreCase("Best Sellers")) {
            return new BestSellersPage(driver);
        } else if (categoryName.equalsIgnoreCase("Books")) {
            return new com.solvd.carina.web.BookPage(driver);
        }
        throw new RuntimeException("Category not recognized: " + categoryName);
    }
}
