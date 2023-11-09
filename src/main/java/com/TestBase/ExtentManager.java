package com.TestBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static com.aventstack.extentreports.ExtentReports extent;

    public synchronized static ExtentReports getReporter(){

        if(extent==null){
            String workingDir=System.getProperty("user.dir");
            extent= new ExtentReports();
            extent.attachReporter(new ExtentSparkReporter(workingDir+"\\ExtentReports\\ExtentReportResult.html"));
        }
        return extent;
    }
}
