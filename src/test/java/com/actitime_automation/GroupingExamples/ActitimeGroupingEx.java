package com.actitime_automation.GroupingExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActitimeGroupingEx {
        WebDriver driver;

        @BeforeMethod
        public void launchBrowser() {
            driver = new ChromeDriver();
            driver.get("http://127.0.0.1:81/login.jsp");
        }

        @AfterMethod
        public void closeBrowser() {
            driver.close();
        }

        @Test(groups={"regression","smoke","intgration"})
        public void verifyLoginPageTitle() {
            String ActualTitle = driver.getTitle();
            String ExpeTitle = "actiTIME - Login";
            if (ExpeTitle.equals(ActualTitle)) {
                System.out.println("Login title is as expected.");
            } else {
                System.out.println("Login title is NOT as expected.");
            }
        }

        @Test(groups={"regression","smoke","intgration"})
        public void VerifytheLoginPageURl() {
            String ActualURL = driver.getCurrentUrl();
            String ExpactedURl = "http://127.0.0.1:81/login.jsp";
            if (ExpactedURl.equals(ActualURL)) {
                System.out.println("Login url is as expected.");
            } else {
                System.out.println("Login url is NOT as expected.");
            }
        }

        @Test(groups={"regression","smoke","intgration"})
        public void verifyLoginFunctionality() {
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("pwd")).sendKeys("manager");
            driver.findElement(By.id("loginButton")).click();
            WebElement ttTab = driver.findElement(By.xpath("//a[@class='content tt_selected selected']/div[1]"));
            if (ttTab.isDisplayed()) {
                System.out.println("Dashboard page is displayed.");
            } else {
                System.out.println("Dashboard page is NOT displayed.");
            }
        }
    }

