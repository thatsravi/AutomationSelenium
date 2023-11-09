package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // WebDriver driver;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userName;

     @FindBy(xpath = "//input[@id='password']")

     WebElement passWord;                            

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;


    public void enterUserName(String user) {

     Helpers.sendKeys(user,userName);
        Helpers.waitFor(1);
    }

    public void enterPassWord(String pass) {

     Helpers.sendKeys(pass,passWord);
        Helpers.waitFor(1);
    }

    public void clickLogin() {

        Helpers.clickOnElement(loginButton, "login button clicked");
        Helpers.waitFor(1);
    }
}
