package com.actitime_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigatemethod
{
    public static void main (String[]args)throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        // Using get() to load a URL
        driver.get("https://www.amazon.in/");

// Using navigate() for advanced navigation
        driver.navigate().to("https://www.amazon.in/minitv?ref_=nav_avod_desktop_topnav");
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
    }
}
