package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class featchAllLinks
{
    public static void main(String []args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("Yellow");
        colors.add("Blue");
        colors.add("Pink");

        for(String values:colors)
        {
            System.out.println(values);
        }
        List<WebElement> links = /*(List<WebElement>)*/driver.findElements(By.tagName("a"));
        System.out.println("Total links"+ links.size());
        for (WebElement element : links)
        {
            String link = element.getAttribute("href");
            if (!link.startsWith("tel:"))
            {
                System.out.println(link);
            }
        }

        driver.close();
    }

}
