package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CurrencyVerification extends Utils {

    private By _currency = By.id("customerCurrency");

    public void dollarEuroVerification() {


        //Selecting Dollar currency from the list
        selectFromDropDownListByVisibleText(_currency, "US Dollar");


        //Listing all the prices from the given locators
        List<WebElement> productPriceInDollar = driver.findElements(By.xpath("//div[@class='prices']"));
        for (WebElement element : productPriceInDollar) {

            //for loop to verify if the text of element shows the dollar sign

            for (int i = 0; i < productPriceInDollar.size(); i++) {

                String price = productPriceInDollar.get(i).getText();

                //assert to verify the test pass if $ sign is present

                Assert.assertTrue(price.contains("$"), "$ sign not present");

            }


        }

        //Selecting Euro currency from the list
        selectFromDropDownListByVisibleText(_currency, "Euro");


        //Listing all the prices from the given locators
        List<WebElement> productPriceInEuro = driver.findElements(By.xpath("//span[@class='price actual-price']"));

        for (WebElement element : productPriceInEuro) {


            //for loop to verify if the text of element shows the euro sign
            for (int i = 0; i < productPriceInEuro.size(); i++) {

                //this is to store element text in to variable price
                String price = productPriceInEuro.get(i).getText();

                //assert to verify the test pass if € sign is present
                Assert.assertTrue(price.contains("€"), "€ sign not present");

            }


        }

    }
}


