package Utils;

import com.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.ss.formula.functions.T;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Iterator;

public class MyListeners implements ITestListener {
    Integer i=0;
    String num="";
    static  String config_path="./src/configuration.properties";

    private static String getTestMethodName(ITestResult iTestResult)
    {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext context)
    {
        TestBase.htmlReport=System.getProperty("user.dir")+"/ExtentReports/ExtentReportResults_"+Helpers.getCurentDateTime()+".html";
        TestBase.htmlReport=System.getProperty("user.dir")+"/ExtentReports/ExtentReportResults.html";
        TestBase.htmlReporter= new ExtentSparkReporter(TestBase.htmlReport);
        TestBase.reports= new ExtentReports();
        TestBase.reports.attachReporter(TestBase.htmlReporter);
        TestBase.htmlReporter.config().setDocumentTitle("Automation Report");
        TestBase.htmlReporter.config().setTheme(Theme.STANDARD);
        TestBase.htmlReporter.config().setEncoding("utf-8");
        TestBase.reports.setSystemInfo("Environment","QA");
        TestBase.reports.setSystemInfo("Browser",Common_Utils.getProperty(config_path,"browser"));
        TestBase.reports.setSystemInfo("APP URL",Common_Utils.getProperty(config_path,"url"));
        TestBase.reports.setSystemInfo("Environment","QA");

        String project="Automation Project";
        if(System.getProperty("environment")=="tfs");
        project="Namm ";
      //  ExtentKlovReporter klov= new ExtentKlovReporter(project);
       // klov.initMongoDbConnection("10.10.197.20");
     //   klov.initKlovServerConnection("http://10.10.20.30");
      //  TestBase.reports.attachReporter(klov);


    }
    public void onFinish(ITestContext context)
    {
        TestBase.reports.flush();
        EmailUtils emailUtils= new EmailUtils();
      //  emailUtils.sendEmailReport();

        Iterator<ITestResult> skippedTestCase= context.getSkippedTests().getAllResults().iterator();
        while (skippedTestCase.hasNext())
        {
            ITestResult skippedTestCases=skippedTestCase.next();
            ITestNGMethod method= skippedTestCases.getMethod();
            if(context.getSkippedTests().getResults(method).size()>0){
                System.out.println("Removing "+skippedTestCases.getTestClass().toString());
                skippedTestCases.removeAttribute("");
            }

        }
    }
}
