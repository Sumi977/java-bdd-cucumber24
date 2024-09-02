package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath= "//span[normalize-space()='Admin']")
    WebElement adminTabOnSideMenu;
    @FindBy(xpath= "//span[normalize-space()='PIM']")
    WebElement PIMTabOnSideMenu;
    @FindBy(xpath= "//span[normalize-space()='Leave']")
    WebElement leaveTabOnSideMenu;
    @FindBy(xpath= "//h6[normalize-space()='Admin']")
    WebElement AdminTitleOnHeader;
    @FindBy(xpath= "//h6[normalize-space()='PIM']")
    WebElement PIMTitleOnHeader;
    @FindBy(xpath= "//h6[normalize-space()='Leave']")
    WebElement leaveTitleOnHeader;



    public void clickOnPIMTab(){
        PIMTabOnSideMenu.click();
    }
    public void clickOnAdminTab(){
        adminTabOnSideMenu.click();
    }
    public void clickOnLeaveTab(){
        leaveTabOnSideMenu.click();
    }

    public boolean checkIfAdminPageVisible(){
        return AdminTitleOnHeader.isDisplayed();
    }

    public boolean checkIfPIMPageVisible(){
        return PIMTitleOnHeader.isDisplayed();
    }

    public boolean checkIfLeavePageVisible(){
        return leaveTitleOnHeader.isDisplayed();
    }


}
