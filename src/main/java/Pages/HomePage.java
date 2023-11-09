package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    public HomePage () {
        PageFactory.initElements(driver,this);
    }

    // WebDriver driver;
    @FindBy(xpath="//span[@class=\"title\"]")
    WebElement product;

    @FindBy(xpath="//div[text()='Swag Labs']")
    WebElement titleSwag;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement bagPackAddToCart;

    @FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement bikeLightAddToCart;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    WebElement tshirtAddToCart;

    @FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
    WebElement addToCart;

    public Boolean homePageDisplayed()
    {
        return Helpers.verifyElementDisplayed(titleSwag);

    }

    public Boolean productDisplayed()
    {
       return Helpers.verifyElementDisplayed(product);

    }

    public String getHomePage()
    {
        return Helpers.getText(titleSwag);

    }
    public void click3ProductItemsandAddtoCart()
    {
         Helpers.clickOnElement(bagPackAddToCart,"");
        Helpers.clickOnElement(bikeLightAddToCart,"");
        Helpers.clickOnElement(tshirtAddToCart,"");

    }
    public void clickAddtoCart()
    {
        Helpers.clickOnElement(addToCart,"Add to cart clicked");

    }


}