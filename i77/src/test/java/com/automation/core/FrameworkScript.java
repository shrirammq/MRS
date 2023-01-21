package com.automation.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkScript {
	
	protected WebDriver driver = null;

	// Open Browser
	@Parameters({"Browser"})
	@BeforeTest
	public void openBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}


		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.manage().window().maximize();

	}

	
	// Close Browser
	@AfterTest
	public void closeBrowser() {

		driver.quit();
	}

}
