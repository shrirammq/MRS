package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(partialLinkText = "Logout")
	private WebElement lnkLogout = null;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logout() {
		lnkLogout.click();
	}

}
