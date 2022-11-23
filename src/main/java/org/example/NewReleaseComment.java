package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewReleaseComment extends Utils{

    public void commentOnNewRelease(){

        //To store confirmation message for later to verify against actual using Assert
        String commentConfirmationMessage = "News comment is successfully added.";

        //click on details
        clickOnElement(By.className("read-more"));

        //passing comment comment title
        sendText(By.id("AddNewComment_CommentTitle"), "Prakash");

        //passing comment comment text
        sendText(By.id("AddNewComment_CommentText"), "Brilliant");

        //clicking on add comment button
        clickOnElement(By.name("add-comment"));


        //to verify if the comment has been successfully added
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"result\"]")).getText(), commentConfirmationMessage,"Your comment has not been added");


        //storing all the comments title in the list
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class=\"comment-title\"]"));


        //for loop to access each comments
        for(WebElement element:comments){

            //for loop to go to second last comment and increasing by 1
            for(int i=comments.size()-1;i<=comments.size()-1;i++)

            {
                //verifying that comment with actual comment that was entered earlier
                Assert.assertEquals(comments.get(i).getText(), "Prakash");


            }

    }

}
}

