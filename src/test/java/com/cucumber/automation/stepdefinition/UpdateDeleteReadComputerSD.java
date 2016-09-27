package com.cucumber.automation.stepdefinition;

import java.util.List;

import com.cucumber.automation.pages.ComputerCRUD;
import com.cucumber.automation.pages.HomePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UpdateDeleteReadComputerSD {

    HomePage homePage = new HomePage();
    ComputerCRUD compCRUD= new ComputerCRUD();
 
    //Scenario: Verify the content of existing Computer
    @When("^i search for a computer \"([^\"]*)\"$")
    public void i_search_for_a_computer(String arg1)  {
        homePage.searchComputer(arg1);
    }

    @Then("^i see the searched computer \"([^\"]*)\" in table$")
    public void i_see_the_computer_in_table(String text)  {
       assertTrue(homePage.isSearchedRstVisible(text));
    }

    @When("^i click on searched result \"([^\"]*)\"$")
    public void i_click_on_searched_result(String text) throws InterruptedException  {
	homePage.clickSearchedComputer(text);
	Thread.sleep(5000);
    }

    @Then("^i can see following details of the computer$")
    public void i_can_see_following_details_of_the_computer(DataTable arg1)  {
       
        List<List<String>> details = arg1.raw();
        assertEquals(details.get(1).get(0),compCRUD.returnCompName());
        assertEquals(details.get(1).get(1),compCRUD.returnIntroDate());
        assertEquals(details.get(1).get(2),compCRUD.returnDiscnDate());
    }
    //Scenario: Verify the content of existing Computer
    
    //Scenario: Verify if delete computer is working
    @When("^click on Delete this computer button$")
    public void click_on_Delete_this_computer_button() throws InterruptedException {
        compCRUD.clickdeleteButton();
    }

    @When("^i see success msg \"([^\"]*)\"$")
    public void i_see_success_msg(String arg1) {
	assertEquals(arg1, homePage.returnAlertMessage());
    }
    //Scenario: Verify if delete computer is working
}
