package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.utilities.GenericUtility;

import java.util.List;

public class FlipkartProgramUsingGenericUtility {
    @Test
    public void printdata() throws InterruptedException {
        System.out.println("** Program Starts **");
        String bName = "ch";
        String url = "https://www.flipkart.com/";
        GenericUtility gu = new GenericUtility();
        WebDriver driver = gu.startUp(bName, url);
        try {
            driver.findElement(By.cssSelector("._30XB9F")).click();
        } catch (Exception e) {
            System.out.println("Login popup is not displayed.");
        }
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("iphone 14prom max");
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);
        gu.waitForPageLoad(driver, 30);

        List<WebElement> mobileNames = driver.findElements(By.cssSelector(".KzDlHZ"));
        List<WebElement> mobilePrices = driver.findElements(By.cssSelector(".Nx9bqj._4b5DiR"));
        for(int i=0; i<mobileNames.size(); i++) {
            System.out.println("Name : " + mobileNames.get(i).getText());
            System.out.println("Price : " + mobilePrices.get(i).getText());
            System.out.println();
        }
        while(!driver.findElements(By.xpath("//span[text()='Next']")).isEmpty()) {
          driver.findElements(By.xpath("//span[text()='Next']")).stream().findFirst().get();

           Thread.sleep(5000);
            gu.waitForPageLoad(driver, 30);
            for(int i=0; i<driver.findElements(By.cssSelector(".KzDlHZ")).size(); i++) {
                System.out.println("Name : " + driver.findElements(By.cssSelector(".KzDlHZ")).get(i).getText());
                System.out.println("Price : " + driver.findElements(By.cssSelector(".Nx9bqj._4b5DiR")).get(i).getText());
                System.out.println();
            }
        }

        System.out.println("** Program Ends **");
    }
}
