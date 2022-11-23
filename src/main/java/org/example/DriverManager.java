package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;

public class DriverManager extends Utils{

    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().deleteAllCookies();
        driver.get("https://demo.nopcommerce.com/");


    }

    public void closeBrowser(){

        driver.quit();

    }

}
