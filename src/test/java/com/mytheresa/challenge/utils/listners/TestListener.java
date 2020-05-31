package com.mytheresa.challenge.utils.listners;

import com.aventstack.extentreports.Status;
import com.mytheresa.challenge.utils.extentReports.ExtentManager;
import com.mytheresa.challenge.utils.extentReports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    /**
     * Event listener for onFinish event, flushes the ExtentManager instance.
     *
     * @param context context set in @BeforeMethod
     */
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    /**
     * Set test name in the report as its description instead of Method name.
     *
     * @param result captured test result
     */
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }
}
