package com.framework.listners;

import com.framework.lib.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListenerTestNG implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestingDocs>> onTestStart ::" + result.getMethod()
                .getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("TestingDocs>> onTestSuccess ::" + result.getMethod()
                .getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("TestingDocs>> onTestFailure ::" + result.getMethod()
                .getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestingDocs>> onTestSkipped ::" + result.getMethod()
                .getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("TestingDocs>> OnStart ::" + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("****************TestRun Report Header********************");
        Log.info("Total Passed" + context.getPassedTests());
        Log.info("Total Failed" + context.getFailedTests());
        Log.info("Total Skipped" + context.getSkippedTests());
        Log.info("*****************TestRun Report Footer ********************");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
    }
}
