import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends Base implements ITestListener {
    ExtentReports extent = ExtentReporter.getReport();
    ExtentTest test;
    //for a thread safe test report on parallel execution
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        //add test object to the thread pool
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //extentTest.get() => ThreadLocal will check the pool and give the valid test object
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        //capture failed test name
        String testCaseName = result.getMethod().getMethodName();
        WebDriver driver = null;
        //access the driver
        try {
            driver = getDriver();
        } catch (Exception e){
            e.printStackTrace();
        }
        //capture screenshot
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testCaseName, driver),testCaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
