package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends TestBase {

    public CheckOutCompletePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[@class=\"title\"]")
    WebElement titleCheckoutComplete;

    @FindBy(xpath="//h2[@class=\"complete-header\"]")
    WebElement titleCompleteheader;

    // WebDriver driver;

    public String titleCheckOutComplete()
    {
        return Helpers.getTextByAttributeValue(titleCheckoutComplete);
    }
    public String titleCompleteheader()
    {
        return Helpers.getText(titleCompleteheader);

    }

}