package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(id = "hmenu-container")
    private ExtendedWebElement menuContainer;


    public HamburgerMenu(WebDriver driver) {
        super(driver);

    }

    public boolean isMenuOpened() {
        return menuContainer.isElementPresent(5) && menuContainer.isVisible();
    }

    public AbstractPage selectCategory(String categoryName) {

        ExtendedWebElement categoryLink = menuContainer.findExtendedWebElement(
                By.xpath(".//a[normalize-space(text())='" + categoryName + "']")
        );
        categoryLink.click();

        if ("Best Sellers".equalsIgnoreCase(categoryName)) {
            return initPage(getDriver(), BestSellersPage.class);
        } else if ("Books".equalsIgnoreCase(categoryName)) {
            return initPage(getDriver(), BookPage.class);
        }
        throw new RuntimeException("Category not recognized: " + categoryName);
    }
}
