package Utils;

import com.TestBase.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.ScreenCapture;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers extends TestBase {

    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public static void dismissAlertIfDisplayed()
        {
            try {
                driver.switchTo().alert().dismiss();
                test.log(Status.INFO,"Window alert dismissed");
            }catch (Exception e)
            {
                test.log(Status.FAIL,"Window alert not dismissed");

            }
        }

    public static void clickOnElement(WebElement element, String elename) {

       try {
            element.click();
         //   test.log(Status.INFO, "Click on Element " + elename);

        } catch (Exception e) {
            executer.printStackTrace();

        }

    }
    public static void sendKeys(String elevalue,WebElement element)
    {
        element.clear();
        element.sendKeys(elevalue);
      //  test.log(Status.INFO,"Value sent  to element" +element.getAttribute("name")+": " +elevalue);

    }
    public static boolean waitForElementTobeVisible(WebElement element)
    {
        try {
            WebDriverWait wait= new WebDriverWait(driver,120);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e) {
            executer.printStackTrace();
            return false;
        }
    }
    public static boolean waitForElementTobeClickable(WebElement element)
    {
        try {
            WebDriverWait wait= new WebDriverWait(driver,120);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e) {
            executer.printStackTrace();
            return false;
        }
    }
        public static boolean verifyElementDisplayed(WebElement element)
        {
            try {
                Helpers.waitForElementTobeVisible(element);
                return element.isDisplayed();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
    public static boolean verifyElementEnabled(WebElement element)
    {
        try {
            return element.isEnabled();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean isCheckBoxSelected(WebElement element)
    {
        try {
            return element.isSelected();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
        public static String getTextByAttributeValue(WebElement ele)
        {
            try {
                return ele.getAttribute("value");
            }catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
        public static Media screenshot()
        {
            String contact1=".";
            File fi;
            ScreenCapture screenshot=null;
            String scrPath ="/.Screenshots/"+System.currentTimeMillis()+"img.png";
            String scrrenshotName=contact1+scrPath;
            try {
                fi=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(fi, new File(scrPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            screenshot=(ScreenCapture) MediaEntityBuilder.createScreenCaptureFromPath(String.valueOf(screenshot)).build();
            return screenshot;
        }

        public static String getScreenshot() throws IOException {
            File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String imgpath ="./"+"/.Screenshots/"+System.currentTimeMillis()+"img.png";
            File path= new File(imgpath);
            FileUtils.copyFile(sourceFile,path);
            return imgpath;
        }
        public static String getText(WebElement ele)
        {
            try {
                return ele.getText();
            }catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
        public static String getCurentDateTime(){

            DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
            Date currentDate= new Date();
            return  customFormat.format(currentDate);
        }
        public static void hoverOver(WebElement element)
        {
            Common_Utils.verifyWebElement(element);
            action= new Actions(driver);
            action.moveToElement(element).clickAndHold().build().perform();
        }
        public static void scrollDown()
        {
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350","");
        }
    public static void scrollDowntoBottom()
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
