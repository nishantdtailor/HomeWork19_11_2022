package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage
{

    public void clickOnElement(By by)
    {

        driver.findElement(by).click();

    }
    public void sendText(By by, String text)
    {

        driver.findElement(by).sendKeys(text);

    }
    public String captureText(By by)
    {

        return driver.findElement(by).getText();


    }
    public static String timeStamp() {

        return new SimpleDateFormat("yyyyDDHHmmss").format(new Date());
    }
    public void selectFromDropDownListByVisibleText(By by, String vText){

        Select selectText = new Select(driver.findElement(by));
        selectText.selectByVisibleText(vText);

    }
    public void selectFromDropDownListByIndext(By by, int index) {

        Select selectByIndex = new Select(driver.findElement(by));
        selectByIndex.selectByIndex(index);
    }
    public void selectFromDropDownListByValue(By by, String value){

        Select selectByValue = new Select(driver.findElement(by));
        selectByValue.selectByValue(value);

    }
    public void waitForTheElementToBeClickable(By by, int timeInSecond){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForTheElementToBeVisible(By by, int timeInSecond){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    public void waitForTheUrlToBe(String url, int timeInSecond){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
        wait.until(ExpectedConditions.urlToBe(url));

    }


    //method to create screenshot file name as method name
    public static void screenShotName(ITestResult result){

        result.getName();
    }


    //method to capture the screenshot
    public static void captureScreenshot(String screenshotName) {

        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);


        File destinationFile = new File("src/ScreenShots/"+screenshotName +timeStamp()+".jpg");
        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}




