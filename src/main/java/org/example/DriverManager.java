package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils{


    //String browserName = LoadProp.getProperty("browser");

    //String browserName = "edge";

    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    String browserName = LoadProp.getProperty("browser");
    //    String browserName = System.getProperty("browser");
    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();


    public void openBrowser(){

        //run in cloud==========================================================================================


        if (runIncloud)
        {

            System.out.println("Running in Cloud");
            //connect to cloud

            if (browserName.equalsIgnoreCase("Edge"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else {

                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);


            }







        }
        else
        {
            //run in local machine

            System.out.println("Running Locally");

            if (browserName.equalsIgnoreCase("Chrome")) {

                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
                driver = new ChromeDriver();

            }
            else if (browserName.equalsIgnoreCase("Firefox")){

                System.setProperty("webdriver.gecko.driver", "src/test/java/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();

            }else if (browserName.equalsIgnoreCase("Edge")){

                System.setProperty("webdriver.edge.driver", "src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            else{

                System.out.println("Your browser name is incorrect or missing implementation "+browserName);
            }

        }





        driver.manage().window().maximize();;
        driver.manage().deleteAllCookies();
        driver.get(LoadProp.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    public void closeBrowser(){

        driver.quit();

    }

}
