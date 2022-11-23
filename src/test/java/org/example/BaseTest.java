package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {

    DriverManager driverManager = new DriverManager();
    private ITestResult result;


    @BeforeMethod
    public void setUp(){

        driverManager.openBrowser();
    }

    @AfterMethod//Executes after each test method
    public void teardown(ITestResult result)
    {
        if (!result.isSuccess()){
            captureScreenshot(result.getName());
        }
        // to close the browser
        driver.quit();
    }
}

