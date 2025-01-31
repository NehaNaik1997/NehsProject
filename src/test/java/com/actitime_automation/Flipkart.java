package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Flipkart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com/");

            // Close login pop-up if it appears
            try {
                WebElement closePopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
                closePopup.click();
            } catch (Exception ignored) {
                // No pop-up to close
            }

            // Search for the product
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("iphone 14 pro max");
            searchBox.submit();

            // Pagination loop
            boolean hasNextPage = true;

            while (hasNextPage) {
                // Wait for search results to load
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div._1AtVbE")));

                // Get phone names and prices
                List<WebElement> phoneNames = driver.findElements(By.cssSelector("div._4rR01T")); // Updated selector
                List<WebElement> prices = driver.findElements(By.cssSelector("div._30jeq3._1_WHN1")); // Updated selector

                // Print the phone details
                for (int i = 0; i < phoneNames.size(); i++) {
                    String name = phoneNames.get(i).getText();
                    String price = prices.get(i).getText();
                    System.out.println("Name of the phone: " + name + "   Price of the phone: " + price);
                }

                // Check if the "Next" button is available
                try {
                    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
                    nextButton.click();
                } catch (Exception e) {
                    // No "Next" button found, end the loop
                    hasNextPage = false;
                }
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
