package com.solvd.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OpenSign extends AbstractPage {


    @FindBy(id = "ap_email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private ExtendedWebElement signInButton;

    public OpenSign(WebDriver driver) {
        super(driver);
        setPageURL("/ap/signin");

        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

        setUiLoadedMarker(emailInput);
    }


    //Perform login with given username (email/phone) and password.

    public void login(String username, String password) {
        emailInput.type(username);
        continueButton.click();
        passwordInput.type(password);
        signInButton.click();
    }
}

