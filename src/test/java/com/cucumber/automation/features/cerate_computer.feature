Feature: Create Computer
  In order to test create Computer functionality
    As a tester
    I want to specify test scenarios

  Scenario: Generic Content of main screen
    Given I am on landing screen for demo app
    Then I see application title
    And I see banner for number of computers
    And I see a filter option
    And an option to add a new computer
    And a table for displaying existing computers
    And a page counter with option to go back and forth

  Scenario: Add a computer Screen - Generic content
    Given I am on Add a Computer screen
    Then I see screen Title as "Add a computer"
    And an option to add computer Name
    And an option to add Introduced date
    And an option to add Discontinued date
    And an drop down to select company
    And create button with text "Create this computer"
    And cancel button with text "Cancel"

  Scenario: Add a computer Screen - in-line Help content
    Given I am on Add a Computer screen
    Then I see in-line help for Computer Name as "Required"
    And I see in-line help for IntroducedDate as "Date ('yyyy-MM-dd')"
    Then I see in-line help for DiscontinuedDate as "Date ('yyyy-MM-dd')"

  Scenario Outline: Verifying edge Scenarios for Create Computer
    Given I am on Add a Computer screen
    When I Enter a "<name>" in Computer Name
    And I Enter "<IntroDate>" in Introduced Date
    And I Enter "<DiscnDate>" in Discontinued Date
    And i click on Create Computer
    Then i see this "<msg>"

    Examples: positive scenario- General
      | name           | IntroDate  | DiscnDate  | msg                                                    |
      #both dates in future
      | garg_compName  | 2016-09-30 | 2016-10-05 | Success:Done! Computer garg_compName has been created  |
      #no dates at all
      | garg1_compName |            |            | Success:Done! Computer garg1_compName has been created |
      #only Intro-date ( in future)
      | garg2_compName | 2016-09-30 |            | Success:Done! Computer garg2_compName has been created |
      #Intro-date ( in future) and Discn Date in future
      | garg2_compName | 2016-09-30 | 2016-10-30 | Success:Done! Computer garg2_compName has been created |
      #only Intro-date ( in past)
      | garg3_compName | 2016-08-30 |            | Success:Done! Computer garg3_compName has been created |
      #Intro-date ( in past) and Discn date in past
      | garg3_compName | 2016-08-30 | 2016-08-31 | Success:Done! Computer garg3_compName has been created |
      #Intro-date ( in past) and Discn date in future
      | garg3_compName | 2016-08-30 | 2016-12-31 | Success:Done! Computer garg3_compName has been created |
      #Discn date earlier then Intro Date ( Although this should have failed but it is passing in this application)
      | garg3_compName | 2016-12-31 | 2016-08-30 | Success:Done! Computer garg3_compName has been created |

    Examples: positive scenario- Computer Name
      | name           | IntroDate  | DiscnDate  | msg                                                                                                                                                                                         |
      #Special Characters in CompName
      | ~@%^&()_+  | 2016-09-30 | 2016-10-05 | Success:Done! Computer ~@%^&()_+ has been created                                                                                                                                       |
      #Very lengthy CompName
      | SSSSSSSSSSSSHHHHHHHHHHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAKKKKKKKKKKKKKKKKKKAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGG^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$ | 2016-09-30 | 2016-10-05 | Success:Done! Computer SSSSSSSSSSSSHHHHHHHHHHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAKKKKKKKKKKKKKKKKKKAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGG^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$ has been created |
      #Only numbers in CompName
      |      123456789 | 2016-09-30 | 2016-10-05 | Success:Done! Computer 123456789 has been created                                                                                                                                           |
      #alphanumeric in CompName
      | sgarg123456789 | 2016-09-30 | 2016-10-05 | Success:Done! Computer sgarg123456789 has been created                                                                                                                                      |
      #space in CompName
      | sgarg garg     | 2016-09-30 | 2016-10-05 | Success:Done! Computer sgarg garg has been created                                                                                                                                          |
      #Duplicate Name
      | garg3_compName | 2016-08-30 |            | Success:Done! Computer garg3_compName has been created                                                                                                                                      |

    Examples: negative scenario- Fields left Blank
      | name          | IntroDate  | DiscnDate  | msg   |
      #All Fields blanks
      | blank         | blank      | blank      | Error |
      #Name as blank
      | blank         | 2016-08-30 | 2016-08-31 | Error |
      #both dates blanks
      | garg_compName | blank      | blank      | Error |
      #Intro date blank
      | garg_compName | blank      | 2016-08-30 | Error |
      #Disc dates blank
      | garg_compName | 2016-08-30 | blank      | Error |

    Examples: negative scenario- Wrong date format
      | name          | IntroDate  | DiscnDate  | msg   |
      #Intro date - wrong format
      | garg_compName | wrongdate  | 2016-08-30 | Error |
      #Dicn date - wrong format
      | garg_compName | 2016-08-30 | wrongdate  | Error |
      #both dates- wrong format
      | garg_compName | wrongdate  | wrongdate  | Error |
      #Intro date - wrong format
      | garg_compName | 30-30-2016 | 2016-08-30 | Error |
      #Dicn date - wrong format
      | garg_compName | 2016-08-30 | 30-30-2016 | Error |
