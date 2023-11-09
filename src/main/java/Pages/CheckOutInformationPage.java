package Pages;

import Utils.Helpers;
import com.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInformationPage extends TestBase {

    public CheckOutInformationPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Checkout: Your Information']")
    WebElement titleCheckout;

    // WebDriver driver;
    @FindBy(xpath="//input[@id=\"first-name\"]")
    WebElement firstName;

    @FindBy(xpath="//input[@id=\"last-name\"]")
    WebElement lastName;

    @FindBy(xpath="//input[@id=\"postal-code\"]")
    WebElement postalCode;

    @FindBy(xpath="//input[@id=\"continue\"]")
    WebElement continueButton;

    public String getCheckOutPageTitle()
    {
        return Helpers.getText(titleCheckout);

    }
    public void enterFirstName(String firstNameValue)
    {
        Helpers.sendKeys(firstNameValue,firstName);
        Helpers.waitFor(1);

    }
    public void enterLastName(String lastNameValue)
    {
        Helpers.sendKeys(lastNameValue,lastName);
        Helpers.waitFor(1);

    }
    public void enterPostalCode(String postalCodeValue)
    {
        Helpers.sendKeys(postalCodeValue,postalCode);
        Helpers.waitFor(1);

    }


    public void clickContinueButton()
    {
        Helpers.clickOnElement(continueButton,"Continue button clicked");
        Helpers.waitFor(1);

    }
}