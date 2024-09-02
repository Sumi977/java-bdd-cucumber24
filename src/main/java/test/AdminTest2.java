package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import setup.DriverFactory;
import setup.Util;

public class AdminTest2 {


    WebDriver driver;
    LoginPage loginPage;
    BasePage basePage;
    AdminPage adminPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void tearUP(){
        driver = DriverFactory.getDriver(Util.getProperties("browserName"));
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        adminPage = new AdminPage(driver);
        homePage = new HomePage(driver);

        basePage.launchApplication(Util.getProperties("url"));
        loginPage.enterUserName(Util.getProperties("username"));
        loginPage.enterPassword(Util.getProperties("password"));
        loginPage.clickOnLoginButton();
        Util.pauseExecutionForSeconds(3);
        Assert.assertTrue(basePage.checkIfUserIconDisplayed());

    }



    @Test(priority = 2, groups = {"regression"})
    public void CheckIfAdminPageIsLoading(){
        homePage.clickOnAdminTab();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfAdminPageVisible());

    }

    @Test(priority = 3, groups = {"sanity"})
    public void CheckIfPIMPageIsLoading(){
        homePage.clickOnPIMTab();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfPIMPageVisible());

    }

    @Test(priority = 4,  groups = {"regression"})
    public void CheckIfLeavePageIsLoading(){
        homePage.clickOnLeaveTab();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfLeavePageVisible());

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        basePage.closeBrowser();
    }

}
