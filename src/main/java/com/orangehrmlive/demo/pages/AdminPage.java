package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//img[@alt='profile picture']" )
    WebElement clickOnUserProfileLogo;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Logout')]" )
    WebElement mouseHoverOnLogout;


    public void setClickOnUserProfileLogo(){
        clickOnElement(clickOnUserProfileLogo);
    }

    public void setMouseHoverOnLogout(){
        mouseHoverToElementAndClick(mouseHoverOnLogout);
    }

}

