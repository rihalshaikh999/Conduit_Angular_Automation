package listener;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseClass implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        extent.flush();
    }

    private String captureScreenshot(String methodName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String destFilePath = "screenshots/" + methodName + "_screenshot.png";
        File destFile = new File(destFilePath);
        FileUtils.copyFile(srcFile, destFile);
        return destFilePath;
    }

}
