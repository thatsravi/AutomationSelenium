import Utils.Assertions;
import com.TestBase.Web_Pages;
import Utils.Common_Utils;
import com.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestClass extends TestBase {
    Web_Pages pages;
    static String config_path="./src/configurations.properties";
    static String username= Common_Utils.getProperty(config_path,"username");
    static String password=Common_Utils.getProperty(config_path,"password");
    static String emailValue=Common_Utils.getProperty(config_path,"email");
    static String emailPassword=Common_Utils.getProperty(config_path,"emailPass");

    @BeforeMethod
    public void beforeClass()
    {
        initializeDriver();
        driver.get(prop.getProperty("url"));
        pages= new Web_Pages();

    }
    @AfterMethod
    public void afterClass()
    {
        // Code for Logout
        closeDriver();

    }

    @Test(description = "TC_H1: Verify Login Sucessfully page", enabled = true)
    public void TC_verifyLoginSucessfully()
    {
        pages.login.enterUserName(username);
        pages.login.enterPassWord(password);
        pages.login.clickLogin();
        Assertions.assertTrue(pages.homePage.homePageDisplayed(),"home page displayed");

        String text=pages.homePage.getHomePage();
        Assert.assertEquals(text,"Swag Labs");


    }

}