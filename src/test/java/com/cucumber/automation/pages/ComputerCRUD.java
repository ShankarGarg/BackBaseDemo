package com.cucumber.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.automation.utils.SeleniumBase;

public class ComputerCRUD extends SeleniumBase{

    
    // All the locators will be defined here
    By banner = By.cssSelector("section#main > h1");
    By comName = By.cssSelector("input#name");
    By introDate = By.cssSelector("input#introduced");
    By discnDate = By.cssSelector("input#discontinued");
    By company = By.cssSelector("select#company");
    By createButton = By.cssSelector("div.actions > input");
    By cancelButton = By.cssSelector("div.actions > a");
    
    By compNameInLine = By.xpath("//*[contains(text(),'Required')]");
    By introDateInLine = By.xpath("//*[contains(text(),'yyyy-MM-dd')]");
    By discnDateInLine = By.xpath("(//*[contains(text(),'yyyy-MM-dd')])[1]");
    
   // By errorLine = By.xpath("(//div[@class=\"error\"]");
    By errorLine = By.cssSelector("div.error");
    
    By deleteButton = By.cssSelector("input.danger");
    
    // All the behavior of home page will be defined here in functions
    public boolean isComAddPage(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(banner));
        return driver.findElement(banner).isDisplayed();
   }
    
    public String bannerValue(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(banner));
        return driver.findElement(banner).getText();
    }
    
    public boolean iscomNamePresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(comName));
        return driver.findElement(comName).isDisplayed();
   }
    
    public boolean isIntroDatePresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(introDate));
        return driver.findElement(introDate).isDisplayed();
   }
    
    public boolean isDiscDatePresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(discnDate));
        return driver.findElement(discnDate).isDisplayed();
   }
    
    public boolean isCompanyPresent(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(company));
        return driver.findElement(company).isDisplayed();
   }
    
    public String returnCompName(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(comName));
        return driver.findElement(comName).getAttribute("value");
   }
    
    public String returnIntroDate(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(introDate));
        return driver.findElement(introDate).getAttribute("value");
   }
    
    public String returnDiscnDate(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(discnDate));
        return driver.findElement(discnDate).getAttribute("value");
   }
    
    public String returnCreateBtnText(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(createButton));
        return driver.findElement(createButton).getAttribute("value");
   }
    
    public String returnCancelBtnText(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(cancelButton));
        return driver.findElement(cancelButton).getText();
   }
    
    public String returnCompNameInLineText(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(compNameInLine));
        return driver.findElement(compNameInLine).getText();
   }
    
    public String returnIntroDateInLineText(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(introDateInLine));
        return driver.findElement(introDateInLine).getText();
   }
    
    public String returnDiscnDateInLineText(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(discnDateInLine));
        return driver.findElement(discnDateInLine).getText();
   }
    
    public void typeCompName(String text){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(comName));
        driver.findElement(comName).clear();
        if(text.equalsIgnoreCase("blank")){
            driver.findElement(comName).sendKeys(" ");
        }
        else{
            driver.findElement(comName).sendKeys(text);
        }
        
    }
    
    public void typeIntroDate(String text){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(introDate));
        driver.findElement(introDate).clear();
        if(text.equalsIgnoreCase("blank")){
            driver.findElement(introDate).sendKeys(" ");
        }
        else{
            driver.findElement(introDate).sendKeys(text);
        }
    }
    
    public void typeDiscnDate(String text){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(discnDate));
        driver.findElement(discnDate).clear();
        if(text.equalsIgnoreCase("blank")){
            driver.findElement(discnDate).sendKeys(" ");
        }
        else{
            driver.findElement(discnDate).sendKeys(text);
        }
    }
    
    public void clickCreateNewButton(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(createButton));
        driver.findElement(createButton).click();
    }
    
    public String returnErrorLineColor(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(errorLine));
        return driver.findElement(errorLine).getCssValue("color");
    }
    
    public String returndeleteButtonValue(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(deleteButton));
        return driver.findElement(deleteButton).getAttribute("value");
   }
    
    public void clickdeleteButton(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(deleteButton));
        driver.findElement(deleteButton).click();
   }
}
