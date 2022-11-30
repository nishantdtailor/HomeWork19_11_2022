package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
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
    public void hoverOnComputer(){

        String softwareUrl = "https://demo.nopcommerce.com/software";

        Actions builder = new Actions(driver);

        WebElement computers = driver.findElement(By.linkText("Computers"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement desktop = driver.findElement(By.xpath("//div[2]/ul[1]/li[1]/ul/li[1]/a"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement notebooks = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement software = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/ul/li[3]/a"));

        //hovering on computers
        builder.moveToElement(computers).build().perform();

        //capturing color of computers element after hovering and storing in the string variable
        String computerColour = computers.getCssValue("color");


        //converting RGB to hex
        String hexColor = Color.fromString(computerColour).asHex();


        //Assert to verify if color of the webelement changes to expected colour upon hovering on it

        Assert.assertEquals(hexColor,"#4ab2f1", "color does not match");


        //hovering to desktop
        builder.moveToElement(desktop).build().perform();

        //capturing background color of the desktop after hovering on it
        String backGroundColorDesktops = desktop.getCssValue("background-color");

        //converting RGB to hex
        String hexDesktopbackGround = Color.fromString(backGroundColorDesktops).asHex();

        //verifying background color with actual
        Assert.assertEquals(hexDesktopbackGround, "#f6f6f6", "background color of desktop does not match !!");

        //hovering on notebooks
        builder.moveToElement(notebooks).build().perform();

        //clicking on software
        builder.moveToElement(software).click().build().perform();

        //verifying if user is on software page
        Assert.assertEquals(driver.getCurrentUrl(), softwareUrl, "You are on wrong page");


    }

    public void searchFunctionality(){


        sendText(By.id("small-searchterms"),LoadProp.getProperty("Search"));

        clickOnElement(By.xpath("//form/button[@type=\"submit\"]"));

        List<WebElement> searchResult = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

        System.out.println(searchResult.size());

        for (WebElement element : searchResult)

            for (int i=0;i<searchResult.size();i++){

                if(element.getText().contains(LoadProp.getProperty("Search"))){

                    System.out.println(element.getText());


                }
                else {

                    System.out.println("No result found with search keyword");
                }


            }

//            if (element.getText().contains(LoadProp.getProperty("Search")))
//            {
//
//
//                System.out.println(searchResult);
//
//            }
//            else
//            {
//
//                System.out.println("Search result not found with given word");
//
//            }



    }


}
