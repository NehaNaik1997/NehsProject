package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown_each_Name_And_Price_Examples
{
    public static void main(String[]args)
    {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in/");

        //locate dropdown
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        //create an object of select class
        Select select = new Select(dropdown);

        //select value by text
        select.selectByVisibleText("Electronics");

        //select by value
        //   select.deselectByValue(search-alias = electronics);

        //select by index
        //  select.selectByIndex(12);

        //enter mobile in search bar
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");

        //click on search box icon
        driver.findElement(By.id("nav-search-submit-button")).click();

        // featching all the links
        List<WebElement> phoname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        {
            System.out.println("Mobile Names and Prices:");

            for (int i = 0 ; i< phoname.size() && i< prices.size(); i++)
            {
                String names1 = phoname.get(i).getText();
                String price1 = prices.get(i).getText();
                System.out.println("mobile name is: "+names1+ " -----> price is: " +price1);
            }

        }



    }


}
