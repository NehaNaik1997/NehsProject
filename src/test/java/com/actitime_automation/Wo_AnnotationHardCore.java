package com.actitime_automation;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class Wo_AnnotationHardCore {
    @Test(priority = 1)
    public void verifyLoginPageTitle()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:81/login.jsp");
        String ActualTitle = driver.getTitle();
        String ExpeTitle = "actiTIME - Login";
        if (ExpeTitle.equals(ActualTitle))
        {
            System.out.println("Login title is as expected.");
        }
        else{
            System.out.println("Login title is NOT as expected.");
        }
        driver.close();
    }
    @Test(priority = 2)
    public void VerifytheLoginPageURl()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:81/login.jsp");
        String ActualURL  = driver.getCurrentUrl();
        String ExpactedURl = "http://127.0.0.1:81/login.jsp";
        if (ExpactedURl.equals(ActualURL))
        {
            System.out.println("Login url is as expected.");
        }
        else{
            System.out.println("Login url is NOT as expected.");
        }
        driver.close();
    }
    @Test(priority = 3)
    public void verifyLoginFunctionality()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:81/login.jsp");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.id("loginButton")).click();
        WebElement ttTab =driver.findElement(By.xpath("//a[@class='content tt_selected selected']/div[1]"));
        if(ttTab.isDisplayed()) {
            System.out.println("Dashboard page is displayed.");
        } else {
            System.out.println("Dashboard page is NOT displayed.");
        }
        driver.close();

    }
}
