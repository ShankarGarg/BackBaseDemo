package com.cucumber.automation.stepdefinition;

import com.cucumber.automation.pages.ComputerCRUD;
import com.cucumber.automation.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CreateComputerSD {

    HomePage homePage = new HomePage();
    ComputerCRUD compCRUD= new ComputerCRUD();
 
    //Scenario: Generic Content of main screen
    @Given("^I am on landing screen for demo app$")
    public void i_am_on_landing_screen_for_demo_app()  {
        assertTrue(homePage.isHomePage());
    }

    @Then("^I see application title$")
    public void i_see_application_title()  {
	assertTrue(homePage.isHomePage());
    }

    @Then("^I see banner for number of computers$")
    public void i_see_banner_for_number_of_computers()  {
	assertTrue(homePage.isbannerpresent());
    }

    @Then("^I see a filter option$")
    public void i_see_a_filter_option()  {
	assertTrue(homePage.isfilterOptionPresent());        
    }

    @Then("^an option to add a new computer$")
    public void an_option_to_add_a_new_computer()  {
	assertTrue(homePage.isaddComputerPresent());      
    }

    @Then("^a table for displaying existing computers$")
    public void a_table_for_displaying_existing_computers()  {
	assertTrue(homePage.iscomTablePresent());
    }

    @Then("^a page counter with option to go back and forth$")
    public void a_page_counter_with_option_to_go_back_and_forth()  {
	assertTrue(homePage.isPaginationPresent());      
    }
  //Scenario: Generic Content of main screen
    
    //Scenario: Add a computer Screen Generic content
    @Given("^I am on Add a Computer screen$")
    public void i_am_on_Add_a_Computer_screen()  {
	homePage.clickAddComButton();
	assertTrue(compCRUD.isComAddPage());
    }

    @Then("^I see screen Title as \"([^\"]*)\"$")
    public void i_see_screen_Title_as(String arg1)  {
	assertEquals(arg1, compCRUD.bannerValue());
    }

    @Then("^an option to add computer Name$")
    public void an_option_to_add_computer_Name()  {
	assertTrue(compCRUD.iscomNamePresent());
    }

    @Then("^an option to add Introduced date$")
    public void an_option_to_add_Introduced_date()  {
	assertTrue(compCRUD.isIntroDatePresent());       
    }

    @Then("^an option to add Discontinued date$")
    public void an_option_to_add_Discontinued_date()  {
	assertTrue(compCRUD.isDiscDatePresent());
    }

    @Then("^an drop down to select company$")
    public void an_drop_down_to_select_company()  {
	assertTrue(compCRUD.isCompanyPresent());
    }

    @Then("^create button with text \"([^\"]*)\"$")
    public void create_button_with_text(String arg1)  {
	assertEquals(arg1, compCRUD.returnCreateBtnText());
    }
    
    @Then("^edit button with text \"([^\"]*)\"$")
    public void edit_button_with_text(String arg1)  {
	assertEquals(arg1, compCRUD.returnCreateBtnText());
    }
    
    @Then("^delete button with text \"([^\"]*)\"$")
    public void delere_button_with_text(String arg1)  {
	assertEquals(arg1, compCRUD.returndeleteButtonValue());
    }

    @Then("^cancel button with text \"([^\"]*)\"$")
    public void cancel_button_with_text(String arg1)  {
	assertEquals(arg1, compCRUD.returnCancelBtnText());       
    }
    //Scenario: Add a computer Screen Generic content
    
    //Scenario: Add a computer Screen in-line Help
    @Then("^I see in-line help for Computer Name as \"([^\"]*)\"$")
    public void i_see_in_line_help_for_Computer_Name_as(String arg1)  {
	assertEquals(arg1,compCRUD.returnCompNameInLineText());
    }

    @Then("^I see in-line help for IntroducedDate as \"([^\"]*)\"$")
    public void i_see_in_line_help_for_IntroducedDate_as(String arg1)  {
	assertEquals(arg1,compCRUD.returnIntroDateInLineText());
    }

    @Then("^I see in-line help for DiscontinuedDate as \"([^\"]*)\"$")
    public void i_see_in_line_help_for_DiscontinuedDate_as(String arg1)  {
	assertEquals(arg1,compCRUD.returnDiscnDateInLineText());
	}
    //Scenario: Add a computer Screen in-line Help
    
    //Scenario Outline: Verifying Scenarios for Create Computer 
    @When("^I Enter a \"([^\"]*)\" in Computer Name$")
    public void i_Enter_a_garg_compName_in_Computer_Name(String arg1)  {
        compCRUD.typeCompName(arg1);
    }

    @When("^I Enter \"([^\"]*)\" in Introduced Date$")
    public void i_Enter_in_Introduced_Date(String arg1)  {
	 compCRUD.typeIntroDate(arg1);
    }

    @When("^I Enter \"([^\"]*)\" in Discontinued Date$")
    public void i_Enter_in_Discontinued_Date(String arg1)  {
        compCRUD.typeDiscnDate(arg1);
    }

    @When("^i click on Create Computer$")
    public void i_click_on_Create_Computer()   {
        compCRUD.clickCreateNewButton();
    }
    
    @When("^i click on Save this Computer$")
    public void i_click_on_Save_Computer()  {
        compCRUD.clickCreateNewButton();
    }

    @Then("^i see this \"([^\"]*)\"$")
    public void i_see_this_msg(String arg1)  {
	if(arg1.contains("Success")){
	    String[] parts = arg1.split(":");
	    assertEquals(parts[1], homePage.returnAlertMessage());
	}
	else if (arg1.contains("Error")){
	    assertEquals("rgba(64, 64, 64, 1)", compCRUD.returnErrorLineColor());
	}
    }
    //Scenario Outline: Verifying Scenarios for Create Computer 
}
