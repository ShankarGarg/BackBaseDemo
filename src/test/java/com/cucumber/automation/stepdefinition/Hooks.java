package com.cucumber.automation.stepdefinition;

import java.net.MalformedURLException;

import com.cucumber.automation.utils.SeleniumBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    
    SeleniumBase seleniumBase = new SeleniumBase();
    
    @Before
    public void beforeHookfunction() throws MalformedURLException, InterruptedException{
	seleniumBase.createDriver();
    }
 
    @After
    public void afterHookfunction() {
	seleniumBase.teardown();
    }

}
