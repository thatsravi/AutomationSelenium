package Utils;

import com.TestBase.TestBase;
import com.aventstack.extentreports.Status;
import net.bytebuddy.implementation.FieldAccessor;
import org.apache.poi.poifs.property.Property;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Common_Utils extends TestBase {

    public static Logger logger= Logger.getLogger(String.valueOf(Common_Utils.class));
    static {
        String log4=System.getProperty("user.dir")+ File.separator + "log4j.properties";
       // PropertyConfigurator.configure(log4);
    }

    public static void verifyWebElement(WebElement element)
    {
        try {
            WebDriverWait wait= new WebDriverWait(Common_Utils.driver,12);
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("WebElement is visible on this page");
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.INFO,"Webelement not visible"+element.toString());
            Assert.fail();
        }
    }

    public static String getProperty(String path, String key)
    {
        String value="";
        try {
            Properties p= new Properties();
            p.load(new FileInputStream(path));
            value= p.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
