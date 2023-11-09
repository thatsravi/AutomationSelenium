package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends TestBase {
    public CustomerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    // WebDriver driver;
    @FindBy(xpath="//input[@name=\"login[password]\"]")
    WebElement password;

    @FindBy(xpath="//input[@id='email']")
    WebElement email;

    @FindBy(xpath="//button[@class='action login primary']/span[.='Sign In']")
    WebElement signin;


    public void sendEmail(String emailVal)
    {
        Helpers.sendKeys(emailVal,email);
        Helpers.waitFor(5);

    }
    public void sendPassword(String passwordVal)
    {
        Helpers.sendKeys(passwordVal,password);
        Helpers.waitFor(5);

    }
    public void clickSignIn()
    {

        Helpers.clickOnElement(signin,"SignIn Button clicked");
        Helpers.waitFor(2);
    }
}