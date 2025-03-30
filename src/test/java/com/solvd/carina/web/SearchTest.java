package com.solvd.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Test(description = "Verify that searching for a product shows relevant results")
    public void testProductSearch() {

        Search searchPage = new Search(getDriver());
        searchPage.openHomePage();
        Assert.assertTrue(searchPage.isPageOpened(), "Amazon home page did not open");
        LOGGER.info("Amazon home page opened");

        String query = "laptop";
        searchPage.searchForProduct(query);

        Assert.assertFalse(searchPage.getSearchResults().isEmpty(), "No results found for the search query!");
        String firstTitle = searchPage.getFirstResultTitle().toLowerCase();
        Assert.assertTrue(firstTitle.contains(query),
                "The first result title does not contain the search term '" + query + "'. Title was: " + firstTitle);
    }
}
