package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BestSellersPage extends AbstractPage {

    // Locator for product cards on the Best Sellers page
    @FindBy(xpath = "//div[contains(@class, 'product-card')]")
    private List<ExtendedWebElement> productCards;

    public BestSellersPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(int index) {
        ExtendedWebElement product = productCards.get(index - 1);
        product.click();
        return new ProductPage(driver);
    }
}
