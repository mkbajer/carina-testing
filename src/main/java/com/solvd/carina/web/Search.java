package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Search extends AbstractPage {

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchButton;

    @FindBy(css = "div.s-main-slot div.s-result-item")
    private List<ExtendedWebElement> searchResults;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement greetingText;

    public Search(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    public Search openHomePage() {
        open();
        return this;
    }

    public Search searchForProduct(String query) {
        searchInput.type(query);
        searchButton.click();
        try {
            searchInput.wait(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public List<ExtendedWebElement> getSearchResults() {
        return searchResults;
    }

    public String getFirstResultTitle() {
        if (searchResults.isEmpty()) {
            return null;
        }
        return searchResults.get(0).getText();
    }

    public String getGreetingText() {
        return greetingText.getText();
    }
}
