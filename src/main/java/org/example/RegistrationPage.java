package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


//Inherited Units Class
public class RegistrationPage extends Utils{


//        Declaration of variable and initiated with the value of the locator

        private By _firstName = By.id("FirstName");
        private By _lastName = By.id("LastName");
        private By _eMail = By.id("Email");
        private By _passWord = By.id("Password");
        private By _confirmPassword = By.id("ConfirmPassword");
        private By _selectDateofBirth = By.name("DateOfBirthDay");
        private By _selectMonthofBirth = By.name("DateOfBirthMonth");
        private By _selectYearofBirth = By.name("DateOfBirthYear");


        public void verifyIfUserIsOnRegisterPage(){

            Assert.assertEquals("https://demo.nopcommerce.com/register?returnUrl=%2F", driver.getCurrentUrl(), "You are not on registration Page");
        }
        public void enterRegistrationInfo(){

            //keying in data with the of methods in the Utils class and with the variables declared above

            sendText(_firstName,LoadProp.getProperty("FirstName"));
            sendText(_lastName, LoadProp.getProperty("LastName"));
            selectFromDropDownListByValue(_selectDateofBirth, LoadProp.getProperty("DateOfBirthDay"));
            selectFromDropDownListByVisibleText(_selectMonthofBirth,LoadProp.getProperty("DateOfBirthMonth"));
            selectFromDropDownListByVisibleText(_selectYearofBirth,LoadProp.getProperty("DateOfBirthYear"));
            //selectFromDropDownListByVisibleText(_selectYearofBirth,"1955");
            sendText(_eMail,LoadProp.getProperty("Email1")+timeStamp()+LoadProp.getProperty("Email2"));
            sendText(_passWord, LoadProp.getProperty("Password"));
            sendText(_confirmPassword,LoadProp.getProperty("ConfirmPassword"));
            clickOnElement(By.id("register-button"));


        }

}
