package listeners;

import utilities.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import config.Base;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    WebDriver driver= null;
    ExtentReports extentReport = ExtentReport.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName + "executed started");
        extentTestThread.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String TestName = result.getName();
        //extentTest.log(Status.PASS, TestName + "got passed");
        extentTestThread.get().log(Status.PASS, TestName + "got passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = null;
        String testMethodName = result.getName();

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String screenshotFilePath = takeScreenshot(testMethodName, driver);
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);

        } catch (IOException e) {

            e.printStackTrace();
        }

       // extentTest.fail(result.getThrowable());
        extentTestThread.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }


}
