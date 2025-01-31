package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlipkartSearchResults
{
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 14");
        searchBox.submit();

            List<WebElement> PhoneNames = driver.findElements(By.cssSelector("div.KzDlHZ"));
            List<WebElement> Prices = driver.findElements(By.cssSelector("div.Nx9bqj._4b5DiR"));
            for (int i = 0; i < PhoneNames.size(); i++)
            {
                String name = PhoneNames.get(i).getText();
                String price = Prices.get(i).getText();
                System.out.println("Name of the phone: " + name + "   Price of the phone: " + price);
            }
         //WebElement ele = driver.findElement(By.xpath("//span[text()='Next']"));
           // ele.click();
        while(!driver.findElements(By.xpath("//span[text()='Next']")).isEmpty()) {
            driver.findElements(By.xpath("//span[text()='Next']")).stream().findFirst().get();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            for(int i=0; i<driver.findElements(By.cssSelector(".KzDlHZ")).size(); i++) {
                System.out.println("Name : " + driver.findElements(By.cssSelector(".KzDlHZ")).get(i).getText());
                System.out.println("Price : " + driver.findElements(By.cssSelector(".Nx9bqj._4b5DiR")).get(i).getText());
                System.out.println();
            }
        }


    }

}





