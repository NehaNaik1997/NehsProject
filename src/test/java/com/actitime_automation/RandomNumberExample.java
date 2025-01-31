package com.actitime_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomNumberExample {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://signon.oracle.com/signin");

        // Define the maximum range
        int maxRange = 100;

        // Generate a random number
        int randomNumber = (int) (Math.random() * maxRange); // Generates a number from 0 to (maxRange - 1)

        // Print the random number
        System.out.println("Random Number: " + randomNumber);

        // Close the driver
        driver.quit();
    }
}

