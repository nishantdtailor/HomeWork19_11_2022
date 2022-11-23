package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends Utils{

    public void clickOnRegistrationButton(){

        clickOnElement(By.linkText("Register"));

    }

    public void clickOnAppleMacBookPro(){

        //this is to click on AppleMAcBookPro from home page
        // which will be after clicking on OK button from registration complete page

        clickOnElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div/div[2]/h2/a"));
    }

    public void voteButtonToVerify_AcceptAlert(){


        clickOnElement(By.id("vote-poll-1"));

        //waiting for 10 seconds whilst webdriver captures alert text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //getting alert text and storing into variable
        String alertText = driver.switchTo().alert().getText();

        //verifying using assert if alert text is correct
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please select an answer");


        //accepting alert
        driver.switchTo().alert().accept();

    }



}
