package com.cucumber.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.automation.utils.SeleniumBase;

public class HomePage extends SeleniumBase{

    
    // All the locators for Home page will be defined here
    By appTitle = By.linkText("Play sample application — Computer database");
    By banner = By.cssSelector("section#main > h1");
    By filterText = By.cssSelector("input#searchbox");
    By filterButton = By.cssSelector("input#searchsubmit");
    By addComputer = By.cssSelector("a#add");
    By comTable = By.cssSelector("table.zebra-striped");
    By pagination = By.cssSelector("div#pagination");
    
    By alertMessage = By.cssSelector("div.alert-message");
 
    
    // All the behavior of home page will be defined here in functions
    public boolean isHomePage(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(appTitle));
        return driver.findElement(appTitle).isDisplayed();
    }
    
    public boolean isbannerpresent(){
         waitVar.until(ExpectedConditions.presenceOfElementLocated(banner));
         return driver.findElement(banner).isDisplayed();
    }
    
    public boolean isfilterOptionPresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(filterButton));
        return driver.findElement(filterButton).isDisplayed();
   }
    
    public boolean isaddComputerPresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(addComputer));
        return driver.findElement(addComputer).isDisplayed();
   }
    
    public boolean iscomTablePresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(comTable));
        return driver.findElement(comTable).isDisplayed();
   }
    
    public boolean isPaginationPresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(pagination));
        return driver.findElement(pagination).isDisplayed();
   }
    
    public void clickAddComButton(){
	waitVar.until(ExpectedConditions.presenceOfElementLocated(addComputer));
	driver.findElement(addComputer).click();
    }
    
    public String returnAlertMessage(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(alertMessage));
        return driver.findElement(alertMessage).getText();
   }
    
    public void searchComputer(String text){
	waitVar.until(ExpectedConditions.presenceOfElementLocated(filterButton));
	driver.findElement(filterText).sendKeys(text);
	driver.findElement(filterButton).click();
    }
    
    public boolean isSearchedRstVisible(String text){
	waitVar.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	return driver.findElement(By.linkText(text)).isDisplayed();
    }
    
    public void clickSearchedComputer(String text){
	waitVar.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	driver.findElement(By.linkText(text)).click();
    }
}
