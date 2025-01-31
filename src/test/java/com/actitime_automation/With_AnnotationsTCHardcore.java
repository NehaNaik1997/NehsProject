package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class With_AnnotationsTCHardcore {
    WebDriver driver;
    @BeforeMethod
    public void launchBrowser()
    {
            ConfigReader cr = new ConfigReader();
            Properties prop = cr.getPropObj();
           // FileInputStream fis1 = new FileInputStream(file);

         driver = new ChromeDriver();
        driver.get("http://127.0.0.1:81/login.jsp");
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
    @Test
    public void verifyLoginPageTitle()
    {
        String ActualTitle = driver.getTitle();
        String ExpeTitle = "actiTIME - Login";
        if (ExpeTitle.equals(ActualTitle))
        {
            System.out.println("Login title is as expected.");
        }
        else{
            System.out.println("Login title is NOT as expected.");
        }
    }
    @Test(priority = 2)
    public void VerifytheLoginPageURl()
    {
        String ActualURL  = driver.getCurrentUrl();
        String ExpactedURl = "URL";
        if (ExpactedURl.equals(ActualURL))
        {
            System.out.println("Login url is as expected.");
        }
        else{
            System.out.println("Login url is NOT as expected.");
        }
    }
    @Test(priority = 3)
    public void verifyLoginFunctionality()
    {
        ConfigReader cr = new ConfigReader();
        Properties prop = cr.getPropObj();
       // driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("username")).sendKeys(prop.getProperty("uName"));
        //driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("pwd"));
        driver.findElement(By.id("loginButton")).click();
        WebElement ttTab =driver.findElement(By.xpath("//a[@class='content tt_selected selected']/div[1]"));
        if(ttTab.isDisplayed()) {
            System.out.println("Dashboard page is displayed.");
        } else {
            System.out.println("Dashboard page is NOT displayed.");
        }
    }

}
