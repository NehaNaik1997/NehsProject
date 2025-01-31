package com.actitime_automation.PageFactoryEx.POM_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    //1.WebElements
    @FindBy(name = "username")
    private WebElement userNameTxtField;

    @FindBy(name = "pwd")
    private WebElement PasswordTxtField;

    @FindBy(id = "loginButton")
    private WebElement LoginButtonfield;

}
