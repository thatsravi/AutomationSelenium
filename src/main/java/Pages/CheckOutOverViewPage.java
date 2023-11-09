package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage extends TestBase {

    public CheckOutOverViewPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Checkout: Overview']")
    WebElement titleCheckout;

    @FindBy(xpath="//div[@class=\"summary_info_label summary_total_label\"]")
    WebElement totalCartValue;

    // WebDriver driver;


    @FindBy(xpath="//button[@id=\"finish\"]")
    WebElement finishButton;


    public void getCheckOutPageTitle()
    {
        Helpers.getTextByAttributeValue(titleCheckout);

    }
    public String getTotalcartValue()
    {
        return Helpers.getText(totalCartValue);

    }
    public void clickFinishButton()
    {
        Helpers.clickOnElement(finishButton,"finish button clicked");
        Helpers.waitFor(1);

    }
}