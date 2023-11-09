import Utils.Assertions;
import Utils.Common_Utils;
import com.TestBase.TestBase;
import com.TestBase.Web_Pages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTestClass extends TestBase {
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
        //    Code for Logout
        closeDriver();

    }

    @Test(description = "TC_2: Verify home page and buy 2 items", enabled = true)
    public void TC_2_verifyHomePageandBuy2Items()
    {

        pages.login.enterUserName(username);
        pages.login.enterPassWord(password);
        pages.login.clickLogin();
        Assertions.assertTrue(pages.homePage.homePageDisplayed(),"home page displayed");
        pages.homePage.click3ProductItemsandAddtoCart();
        pages.homePage.clickAddtoCart();
        String text= pages.addToCartPage.getCartPageTitle();
        Assert.assertEquals(text,"Your Cart");
        pages.addToCartPage.removeBikeLightRProduct();
       String twoProduct= pages.addToCartPage.checkProductinCartPage();
        Assert.assertEquals(twoProduct,"2");
        pages.addToCartPage.clickCheckOut();
        String checkoutPage=pages.checkOutInformationPage.getCheckOutPageTitle();
        Assert.assertEquals(checkoutPage,"Checkout: Your Information");
        pages.checkOutInformationPage.enterFirstName("FirstnameEntered");
        pages.checkOutInformationPage.enterLastName("LastNameEntered");
        pages.checkOutInformationPage.enterPostalCode("201310");
        pages.checkOutInformationPage.clickContinueButton();
        pages.checkOutOverViewPage.getCheckOutPageTitle();
        String totalCartValue=pages.checkOutOverViewPage.getTotalcartValue();
        String cartValue=totalCartValue.substring(8);
        Double i=Double.parseDouble(cartValue);
        if(i>30 && i<60)
        {
            System.out.println("We have place order with a total value between $30-$60");

        }

        
    }


}