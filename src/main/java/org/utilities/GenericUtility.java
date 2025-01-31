package org.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class GenericUtility {
    public String getUniqueNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:S");
        String s = sdf.format(new Date());
        s = s.replaceAll("/", "").replaceAll(" ", "").replaceAll(":", "");
        return s;
    }
    public String getCurrentDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
    public void scrollBYActions(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.scrollToElement(ele).perform();
    }
    public void moveByActions(WebDriver driver, WebElement ele)
    {
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
    }
    public void sendKeysByActions(WebDriver driver , WebElement ele,String value)
    {
        Actions act = new Actions(driver);
        act.sendKeys(ele,value).perform();
    }
    public void clickByActions(WebDriver driver, WebElement ele)
    {
        Actions act = new Actions(driver);
        act.click(ele).perform();
    }
    public void contextByActions(WebDriver driver, WebElement ele)
    {
        Actions act = new Actions(driver);
        act.contextClick(ele).perform();
    }
    public void dragAndDropByActions(WebDriver driver, WebElement src,WebElement des)
    {
        Actions act = new Actions(driver);
        act.dragAndDrop(src,des).perform();
    }
    public void dragAndDropByActions(WebDriver driver, WebElement src, int x, int y)
    {
        Actions act = new Actions(driver);
        act.dragAndDropBy(src, x , y).perform();
    }
    public void scrollByJS(WebDriver driver, WebElement ele)
    {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("argument[0].scrollIntoView(true)",ele);
    }
    public void scrollByPageUp(WebDriver driver, int numOfScrolls)
    {
        WebElement ele = driver.findElement(By.xpath("//html"));
        for (int i = 1; i <=numOfScrolls;i++)
        {
            ele.sendKeys(Keys.PAGE_UP);
        }
    }
    public void scrollByPageDown(WebDriver driver,  int numOfScrolls)
    {
        WebElement ele = driver.findElement(By.xpath("//html"));
        for(int i =1; i<=numOfScrolls; i++)
        {
            ele.sendKeys(Keys.PAGE_DOWN);
        }
    }
    public void clickByJS(WebDriver driver, WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",ele);
    }
    public boolean isElementPresent(WebDriver driver,By  byObj)
    {
        try{
            return driver.findElement(byObj).isDisplayed();
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void waitForPageLoad(WebDriver driver,int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void waitForURLContains(WebDriver driver, int time, String partialURL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(partialURL));
    }
    public void waitForURLToBe(WebDriver driver, int time, String exactURL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(exactURL));
    }
    public void waitForTitleContains(WebDriver driver, int time, String partialTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(partialTitle));
    }
    public void waitForTitleIs(WebDriver driver, int time, String exactTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(exactTitle));
    }
    public void waitForVisibilityOfEleByObj(WebDriver driver, int time, By obj) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
        wt.until(ExpectedConditions.visibilityOfElementLocated(obj));
    }

    public void waitForVisibilityByObj(WebDriver driver, int time, String type, String expression) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
        if(type.equalsIgnoreCase("id")) {
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
        } else if(type.equalsIgnoreCase("css")) {
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(expression)));
        } else if(type.equalsIgnoreCase("xpath")) {
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
        } else if(type.equalsIgnoreCase("class")) {
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(expression)));
        } else {        //write for other locator types
            System.out.println("Invalid Locator type...!!!");
        }
    }
    public void waitForVisibilityByType(WebDriver driver, int time, String type, String expression) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
        if(type.equalsIgnoreCase("id")) {
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(expression))));
        } else if(type.equalsIgnoreCase("css")) {
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(expression))));
        } else if(type.equalsIgnoreCase("xpath")) {
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(expression))));
        } else if(type.equalsIgnoreCase("class")) {
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(expression))));
        } else {        //write for other locator types
            System.out.println("Invalid Locator type...!!!");
        }
    }

    public void waitForNumberOfWindows(WebDriver driver, int time, int numOfWindows) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
        wt.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
    }
    public WebDriver startUp(String bName, String url) {
        WebDriver driver = null;
        if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
            //WebDriver driver = new ChromeDriver();
            //driver.manage().window().maximize();
            //OR
            ChromeOptions  options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if(bName.equalsIgnoreCase("edge")) {
            //WebDriver driver = new EdgeDriver();
            //driver.manage().window().maximize();
            //OR
            EdgeOptions  options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            driver = new EdgeDriver(options);

        } else if(bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("firefox")) {
            //WebDriver driver = new FirefoxDriver();
            //driver.manage().window().maximize();
            //OR

            FirefoxOptions  options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);

        } else {
            System.out.println("Invalid Browser name...!!!");
        }
        driver.get(url);
        return driver;

        }
    }


