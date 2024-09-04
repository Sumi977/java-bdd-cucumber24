package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import setup.DriverFactory;
import setup.Util;



public class LoginSteps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    BasePage basePage;

    @Before
    public void tearUp(){
        driver = DriverFactory.getDriver("chrome");
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    @After
    public void tearDown(){
        basePage.closeBrowser();
    }

    @Given("Launching Website for testing")
    public void launchApplication(){
        Util.pauseExecutionForSeconds(2);
        basePage.launchApplication(Util.getProperties("url"));

    }
    @Given("I am on login page of application")
    public void verifyIfUserIsOnLoginPage(){
        loginPage.checkIfLoginPageVisible();
    }
    @Given("I enter valid user name and password")
    public void provideUserNameAndPassword(){
        loginPage.enterUserName(Util.getProperties("username"));
        loginPage.enterPassword(Util.getProperties("password"));
    }
    @Given("I enter invalid user name and password")
    public void provideInvalidUsernameAndPassword(){
        loginPage.enterUserName("ABcde");
        loginPage.enterPassword("Xyzz");
        Util.pauseExecutionForSeconds(2);


    }
    @Given("I click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @Given("I am landing on home page successfully")
    public void VerifyLoginSuccessfull(){
        Assert.assertTrue(basePage.checkIfUserIconDisplayed());

    }
    @Given("I am getting error for invalid credentials")
    public void verifyLoginFailed(){
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(loginPage.checkIfInvalidCredentialsErrorDisplay());



    }
    @When("I enter username{string}")
    public void enterUserNameInTextBox(String userName){
        loginPage.enterUserName(userName);
        Util.pauseExecutionForSeconds(2);
    }
    @When("I enter password{string}")
    public void enterPasswordInTextBox(String password){
        loginPage.enterPassword(password);
    }


}
