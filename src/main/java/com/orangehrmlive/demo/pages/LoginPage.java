package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement username;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnLogin;

    public void enterUsername(String userName) {
        sendTextToElement(username, userName);
    }

    public void enterPassword(String passWord) {
        sendTextToElement(password, passWord);
    }

    public void setClickOnLogin() {
        clickOnElement(clickOnLogin);

    }

    public void invalidLoginCredentialsErrorMessage() {
        getTextFromElement(errorMessage);
    }
}

