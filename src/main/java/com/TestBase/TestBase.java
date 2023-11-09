package com.TestBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static String htmlReport;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test, parentTest,childTest;
    public static String tempSuiteName="", tempTestName="";
    public static WebDriver driver;
    public static Properties prop;
    public static Properties configFile;
    public static DesiredCapabilities capabilities;
    public static WebDriverWait ewait;
    public static JavascriptException executer;
    public static Actions action;
    public static String downloadFilePath;

    static {
        try{
            prop= new Properties();
            FileInputStream ip= new FileInputStream("./src/configurations.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver initializeDriver() {


        if (driver == null) {
            switch (prop.getProperty("browser")) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-extensions");
                    options.addArguments("--start-maximized");

                    driver = new ChromeDriver(options);




                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver", prop.getProperty("gecko.driver.path"));
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("marionette", true);
                    firefoxOptions.setAcceptInsecureCerts(true);
                    firefoxOptions.addArguments("--disable-infobars");
                    firefoxOptions.addArguments("--disable-notifications");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    System.out.println("Wrong driver choose, plz choose driver");

            }

        }
        return driver;
    }


            public void closeDriver()
            {
                if(driver!=null){
                    driver.quit();
                    driver=null;


        }
    }





}
