package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath= "//input[@placeholder='Username']")
    WebElement userNameTextBox;

    @FindBy(xpath= "//input[@placeholder='Password']")
    WebElement passwordTextBox;

    @FindBy(xpath= "//button[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialErrorMessage;



    public void enterUserName(String userName){
        userNameTextBox.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
    public boolean checkIfLoginPageVisible(){
        return userNameTextBox.isDisplayed();
    }
    public boolean checkIfInvalidCredentialsErrorDisplay(){
        return invalidCredentialErrorMessage.isDisplayed();

    }


}
