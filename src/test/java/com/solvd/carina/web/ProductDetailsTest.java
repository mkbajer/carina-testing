package com.solvd.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(ProductDetailsTest.class);

    @Test(description = "Verify that a product detail page displays correct information")
    public void testProductDetails() {

        Search searchPage = new Search(getDriver());
        searchPage.openHomePage();
        Assert.assertTrue(searchPage.isPageOpened(), "Amazon home page did not open");
        searchPage.searchForProduct("laptop");
        Assert.assertFalse(searchPage.getSearchResults().isEmpty(), "No search results to click on for product details test.");

        searchPage.getSearchResults().getFirst().click();

        ProductDetails detailsPage = new ProductDetails(getDriver());
        Assert.assertTrue(detailsPage.isPageOpened(), "Product details page did not open properly");

        String title = detailsPage.getTitle();
        String price = detailsPage.getPrice();
        Assert.assertNotNull(title, "Product title is missing on the details page.");
        Assert.assertFalse(title.isEmpty(), "Product title is empty.");
        LOGGER.info("Product Title: {}", title);

        Assert.assertNotNull(price, "Product price is not displayed on the details page.");
        Assert.assertFalse(price.isEmpty(), "Product price is empty or not found.");
        LOGGER.info("Product Price: {}", price);
    }
}
