package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'product-card')]")
    private List<ExtendedWebElement> productCards;

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(int index) {
        ExtendedWebElement product = productCards.get(index - 1);
        product.click();
        return new ProductPage(driver);
    }
}
