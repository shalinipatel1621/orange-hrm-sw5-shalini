package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

    @Listeners(CustomListeners.class)
    public class LoginTest extends BaseTest
    {
        //Declaration
        AddUserPage addUserPage;
        AdminPage adminPage;
        DashboardPage dashboardPage;
        HomePage homePage;
        LoginPage loginPage;
        ViewSystemsUsersPage viewSystemUserPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt()
        {
            //Initialisation
            addUserPage= new AddUserPage();
            adminPage = new AdminPage();
            dashboardPage = new DashboardPage();
            homePage = new HomePage();
            loginPage = new LoginPage();
            viewSystemUserPage = new ViewSystemsUsersPage();
        }

        @Test(groups={"Sanity" , "Smoke" ,"Regression"})
        public void verifyUserShouldLoginSuccessfully(){
            //Enter username
           loginPage.enterUsername("Admin");
            //   Enter password
            loginPage.enterPassword("admin123");
            //   Click on Login Button
            loginPage.setClickOnLogin();
            //   Verify "Dashboard" Message
            Assert.assertTrue(dashboardPage.getVerifyTheTextDashboard().contains("WelCome"),"WelCome Text is displayed");

        }

        @Test(groups = {"Smoke" , "Regression"})
        public void verifyThatTheLogoDisplayedOnLoginPage(){
            //Launch the application
            driver.getCurrentUrl();
            //   Verify Logo is Displayed
            homePage.orangeHRMLogo();
        }

        @Test(groups = {"Regression" })
        public void verifyUserShouldLogoutSuccessfully() throws InterruptedException{
            //Login To The application
            loginPage.enterUsername("Admin");
            loginPage.enterPassword("admin123");
            loginPage.setClickOnLogin();
            //   Click on User Profile logo
            adminPage.setClickOnUserProfileLogo();
            //   Mouse hover on "Logout" and click
            adminPage.setMouseHoverOnLogout();
            //   Verify the text "Login Panel" is displayed
            Assert.assertTrue(homePage.setVerifyLoginPanel().contains("Login"), "login message is not displayed");

        }

        @Test(groups = {"Regression" })
        public void verifyErrorMessageWithInvalidCredentials()
        {
            //Enter username
            loginPage.enterUsername("promo123@yahoo.com");
            //   Enter password
            loginPage.enterPassword("promo");
            //   Click on Login Button
            loginPage.setClickOnLogin();
            //   Verify "Dashboard" Message
            Assert.assertTrue(dashboardPage.getVerifyTheTextDashboard().contains("Welcome  Text is not displayed"), "Welcome  Text is not displayed");

        }


}
