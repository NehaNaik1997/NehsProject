package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login_amdocs
{

    public static void main (String [] arg) throws InterruptedException
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jobs.amdocs.com/candidate/login");
        Thread.sleep(5000);


        driver.findElement(By.id("login-email-input")).sendKeys("nehavinodnaik97@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("Neha@1234");
        driver.findElement(By.xpath("//button[@class='btn submit-btn ']")).click();

    }
}
