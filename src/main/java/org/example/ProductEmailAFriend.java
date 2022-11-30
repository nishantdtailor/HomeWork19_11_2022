package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ProductEmailAFriend extends Utils{


    private By _friendsEmail = By.id("FriendEmail");

    private By _personalMessage = By.id("PersonalMessage");

    //Storing confirmation message in variable to verify with actual later stage
    String confirmMessage = "Your message has been sent.";

    public void emailAFriend(){


        //entering details
        sendText(_friendsEmail, LoadProp.getProperty("EmailaFriend1")+timeStamp()+LoadProp.getProperty("EmailaFriend2"));

        //entering details
        sendText(_personalMessage,LoadProp.getProperty("RecommendationText"));

        //clicking on button
        clickOnElement(By.xpath("//div[@class=\"buttons\"]/button"));

        //capturing confirmation message
        String message = captureText(By.className("result"));

        //verifying against actual message
        Assert.assertEquals(confirmMessage,message, "Email not sent");


    }

}
