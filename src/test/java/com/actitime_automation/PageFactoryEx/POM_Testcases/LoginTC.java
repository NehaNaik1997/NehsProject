package com.actitime_automation.PageFactoryEx.POM_Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.ConfigReader;
import org.utilities.GenericUtility;

import java.util.Properties;

public class LoginTC {
    WebDriver driver;
    Properties prop;
    @BeforeMethod
    public void initBrowser()
    {
        ConfigReader ce = new ConfigReader();
        prop = ce.getPropObj();
        GenericUtility gu = new GenericUtility();
        driver = gu.startUp(prop.getProperty("bName"), prop.getProperty("URL"));
    }
   /* @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }*/
    @Test
    public void verifyLoginFunctionality() {
        //launch browser
        //Enter username
        //Enter password
        //Click on login button
        //verify dashboard page displayed
        //assertion
        //close the browser
    }
    @Test
    public void verifyLoginPageFields() {
        //launch browser
        //Verify Username field is displayed
        //Verify Password field is displayed
        //Verify Keep me login checkbox is displayed
        //Verify Login button is displayed
        //Verify Login logos displayed
        //close the browser
    }
    @Test
    public void verifyLoginPageTitle() {
        //launch browser
        //Verify Title
        //close the browser
    }
    @Test
    public void verifyLoginPageURL() {
        //launch browser
        //Verify Title
        //close the browser
    }
}
