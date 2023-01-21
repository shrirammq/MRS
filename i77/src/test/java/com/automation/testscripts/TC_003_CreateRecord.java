package com.automation.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import com.automation.pages.RegisterPage;

public class TC_003_CreateRecord extends FrameworkScript {

	@Test(dataProvider ="getTestData" )
	public void createRecord(String userName, String password, String firstName, String lastName, String gender,
			String date, String month, String year, String address, String mobileNumber) throws Exception {

		// Login
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		Thread.sleep(1000);

		// Register
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.createRecord(firstName, lastName, gender, date, month, year,address, mobileNumber);

		// Logout
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}
	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {

		return ExcelHelper.getTestData("D:\\Testdata.xlsx", "Sheet1");
	}

}
