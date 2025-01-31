package com.actitime_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 class Parent1 {
    @DataProvider
    public Object[][] getLoginCredentials() {
        Object[][] ar = new Object[4][2];

        ar[0][0] = "admin";
        ar[0][1] = "manager";

        ar[1][0] = "admin";
        ar[1][1] = "manager";

        ar[2][0] = "admin";
        ar[2][1] = "manager";

        ar[3][0] = "admin";
        ar[3][1] = "manager";
        return ar;
    }
}
public class DataProviderEx {
@Test(dataProvider = "getLoginCredentials")
public void loginTC(String uName , String pwd) {
    WebDriver driver = new ChromeDriver();
    driver.get("url");
    driver.findElement(By.id("username")).sendKeys("uName");
    driver.findElement(By.name("pwd")).sendKeys("pwd");
    driver.findElement(By.id("loginButton")).click();
}
}
