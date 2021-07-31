package testcases.employee;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
//        System.out.println("Chạy trước cho từng TC");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("Chạy sau cho TC nào passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Chạy sau cho TC bị failed ");
        System.out.println("Task picture then send to report ");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        System.out.println("Chạy sau cho TC bị skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        System.out.println("Chạy sau cho TC bị failed trong khoảng % nào đó");

    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        System.out.println("Chạy trước cho Class");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        System.out.println("Chạy sau cho Class");
    }
}
