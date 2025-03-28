package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends AbstractPage {

    @FindBy(id = "productTitle")
    private ExtendedWebElement productTitle;

    @FindBy(id = "priceblock_ourprice")
    private ExtendedWebElement productPrice;

    public ProductDetails(WebDriver driver) {
        super(driver);

    }


    public String getTitle() {
        return productTitle.getText().trim();
    }


    public String getPrice() {
        return productPrice.isElementPresent() ? productPrice.getText().trim() : null;
    }
}
