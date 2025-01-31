package com.actitime_automation;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String [] args)
    {
        //Launch Browser
        WebDriver driver = new ChromeDriver();

        //navigate to Url
        driver.get("https://naturalicecreams.in/");

        //get the title of the page
        String title = driver.getTitle();

        //print the title
        System.out.println(title);

        //get the current URl
        String currentUrl = driver.getCurrentUrl();

        //print the current url
        System.out.println(currentUrl);

        //close the browser
        driver.close();
    }
}
