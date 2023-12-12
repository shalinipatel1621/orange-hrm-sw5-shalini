package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement hrmLogo;

    @CacheLookup
    @FindBy(xpath = "//li[1]//a[1]//span[1]")
    WebElement adminTab;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement pimTab;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")
    WebElement dashboardTab;
    @CacheLookup
    @FindBy(xpath= "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement verifyLoginPanel;


    public void orangeHRMLogo() {
        verifyThatElementIsDisplayed(hrmLogo);

    }

    public void clickOnAdminTab() {
        clickOnElement(adminTab);
    }

    public void clickOnPIMTab() {
        clickOnElement(pimTab);
    }

    public void clickOnDashboardTab() {
        clickOnElement(dashboardTab);
    }


    public String setVerifyLoginPanel() {
        return getTextFromElement(verifyLoginPanel);

    }
}

