package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends TestBase {

    public AddToCartPage() {
        PageFactory.initElements(driver,this);
    }

    // WebDriver driver;
    @FindBy(xpath="//span[@class=\"title\"]")
    WebElement titleCartPage;

    @FindBy(xpath="//button[@id=\"remove-sauce-labs-bike-light\"]")
    WebElement removeBikeLight;

    @FindBy(xpath="//span[@class=\"shopping_cart_badge\"]")
    WebElement shoppingCartbadge;


    @FindBy(xpath="//button[@id=\"checkout\"]")
    WebElement checkOut;


public String getCartPageTitle()
{
   return Helpers.getText(titleCartPage);

}
    public String checkProductinCartPage()
    {
        return Helpers.getText(shoppingCartbadge);

    }
    public void removeBikeLightRProduct()
    {

        Helpers.clickOnElement(removeBikeLight,"removeBikeLight  product removed");
        Helpers.waitFor(2);
    }

    public void clickCheckOut()
    {

        Helpers.clickOnElement(checkOut,"check out Button clicked");
        Helpers.waitFor(2);
    }
}