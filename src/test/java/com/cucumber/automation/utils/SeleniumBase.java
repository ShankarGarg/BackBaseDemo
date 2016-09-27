package com.cucumber.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {

    public static WebDriver driver;
    public static WebDriverWait waitVar;

    public void createDriver() throws InterruptedException {

	// initializing driver object
	driver = new FirefoxDriver();

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	waitVar = new WebDriverWait(driver, 10);
	
	driver.get("http://computer-database.herokuapp.com/computers");
    }

    public void teardown() {
	// close the app
	driver.quit();
    }
}
