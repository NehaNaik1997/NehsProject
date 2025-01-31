package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class Assignment_MultiTab {
    public static void main(String[] args) throws InterruptedException {
        // Open the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the RedBus website
        driver.get("https://www.redbus.in/");

        // Get the handle first tab
        String FirstTabId = driver.getWindowHandle();
        System.out.println("Main Tab ID: " + FirstTabId);

        //click the help x path is used
        driver.findElement(By.xpath("//li[@id='help_redcare']/div[1]")).click();

        Thread.sleep(5000);

        // Get all window handles
        Set<String> allIds = driver.getWindowHandles();

        for (String id: allIds)
        {
            if (!id.equals(FirstTabId))
            {
                driver.switchTo().window(id);
                break;
            }

        }
        driver.close();
        driver.switchTo().window(FirstTabId);
        System.out.println("title of first tab"+driver.getTitle());


    }

}