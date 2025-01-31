
package com.actitime_automation;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethodsExample
{
    public static void main(String []args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://materializecss.com/radio-buttons.html");
        driver.findElement(By.xpath("//span[text()='Green']")).click();
        boolean greencheckbox = driver.findElement(By.xpath("//span[text()='Green']")).isSelected();
        System.out.println(greencheckbox);

        //Example off getAttribute methods
        driver.get("https://www.pandaworld.in/");
        String srcValue = driver.findElement(By.xpath("//img[@style='top:0px']")).getAttribute("src");
        System.out.println(srcValue);
        driver.close();

    }



}
