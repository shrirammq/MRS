package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement txtUserName = null;

	@FindBy(id = "password")
	private WebElement txtPassword = null;

	@FindBy(id = "Registration Desk")
	private WebElement lnkRDesk = null;

	@FindBy(id = "loginButton")
	private WebElement btnLogin = null;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName,String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		lnkRDesk.click();
		btnLogin.click();

	}

}
