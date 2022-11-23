package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class FacebookPage extends Utils{



    //Storing link for facebook page to verify against later on
    String faceBookUrlToVeriFy = "https://www.facebook.com/nopCommerce";

 public void switchTodWindow(){

     // Store the current window handle


     String mainWindow = driver.getWindowHandle();

   //  System.out.println(driver.getCurrentUrl()+" Main Window URL");

     // Perform the click operation that opens new window

     clickOnElement(By.xpath("//li[@class=\"facebook\"]/a"));




// Switch to new window opened
     for(String winHandle : driver.getWindowHandles()){
         driver.switchTo().window(winHandle);
     }

  //   System.out.println(driver.getCurrentUrl()+" child Window URL");



// Perform the actions on new window
     Assert.assertEquals(faceBookUrlToVeriFy, driver.getCurrentUrl(),"URL verification failed");

// Close the new window, if that window no more required
     driver.close();

 //Switch back to original browser (first window)
     driver.switchTo().window(mainWindow);

 }


}
