package Utils;

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
    @FindBy(xpath="//input[@name='q']")
    WebElement searchBox;

    @FindBy(xpath="//a[@href=\"https://mail.google.com/mail/&ogbl\"]")
    WebElement gamilLink;

    public void clickGmail()
    {
      //  driver.findElement(By.xpath("//a[@href=\"https://mail.google.com/mail/&ogbl\"]")).click();

        Helpers.clickOnElement(gamilLink,"Gmail Link clicked");
    }

}
