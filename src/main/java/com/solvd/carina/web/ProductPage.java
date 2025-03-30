package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(id = "add-to-cart-button")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@id='huc-v2-order-row-confirm-text']")
    private ExtendedWebElement confirmationMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket() {
        addToCartButton.click();
    }

    public boolean verifyProductAddedToBasket() {
        return confirmationMessage.isElementPresent();
    }
}
