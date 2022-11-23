package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationCompletePage extends Utils{

    public void verifyIfRegistrationIsCompleted(){

        Assert.assertEquals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",driver.getCurrentUrl(), "Registration Failed");

        //click on Ok button to return to HomePage
        clickOnElement(By.xpath("//div[@class=\"buttons\"]/a"));

    }

}
