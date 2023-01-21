package com.automation.testscripts;

import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import com.automation.pages.RegisterPage;

public class TC_002_CreateRecord extends FrameworkScript {

	@Test
	public void createRecord() throws Exception {

		// Login
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Admin", "Admin123");
		Thread.sleep(1000);

		// Register
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.createRecord("SCOTT", "TIGER", "Male", "11", "April", "1991", "Hyderabad", "999999");

		// Logout
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}

}
