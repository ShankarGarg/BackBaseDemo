Feature: Update_delete_Read_Computer
  In order to test Update_delete_Read Computer functionality
    As a tester
    I want to specify test scenarios

  # this scenario is to create test data for all other scenario that follow in this feature file
  Scenario Outline: Create few sample Computer for Read, update and delete
    Given I am on Add a Computer screen
    When I Enter a "<name>" in Computer Name
    And I Enter "<IntroDate>" in Introduced Date
    And I Enter "<DiscnDate>" in Discontinued Date
    And i click on Create Computer
    Then i see this "<msg>"

    Examples: Sample Data to be used in scenarios mentioned afer this
      | name        | IntroDate  | DiscnDate  | msg                                                    |
      | garg_read   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_read has been created  |
      | garg_delete | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_delete has been created |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |
      | garg_edit   | 2016-10-30 | 2016-11-05 | Success:Done! Computer garg_edit has been created      |

  Scenario: Verify the content of existing Computer
    Given I am on landing screen for demo app
    When i search for a computer "garg_read"
    Then i see the searched computer "garg_read" in table
    When i click on searched result "garg_read"
    Then I see screen Title as "Edit computer"
    And edit button with text "Save this computer"
    And cancel button with text "Cancel"
    And delete button with text "Delete this computer"
    And i can see following details of the computer
      | name      | Intro Date | Discn Date |
      | garg_read | 2016-10-30 | 2016-11-05 |

  Scenario: Verify if delete computer is working
    Given I am on landing screen for demo app
    When i search for a computer "garg_delete"
    Then i see the searched computer "garg_delete" in table
    When i click on searched result "garg_delete"
    And click on Delete this computer button
    And i see success msg "Done! Computer has been deleted"

  Scenario Outline: Verifying edge Scenarios for update Computer
    Given I am on landing screen for demo app
    When i search for a computer "garg_edit"
    Then i see the searched computer "garg_edit" in table
    When i click on searched result "garg_edit"
    When I Enter a "<name>" in Computer Name
    And I Enter "<IntroDate>" in Introduced Date
    And I Enter "<DiscnDate>" in Discontinued Date
    And i click on Save this Computer
    Then i see this "<msg>"

    Examples: positive scenario- General
      | name           | IntroDate  | DiscnDate  | msg                                                    |
      #both dates in future
      | garg_compName  | 2016-09-30 | 2016-10-05 | Success:Done! Computer garg_compName has been updated  |
      #no dates at all
      | garg1_compName |            |            | Success:Done! Computer garg1_compName has been updated |
      #only Intro-date ( in future)
      | garg2_compName | 2016-09-30 |            | Success:Done! Computer garg2_compName has been updated |
      #Intro-date ( in future) and Discn Date in future
      | garg2_compName | 2016-09-30 | 2016-10-30 | Success:Done! Computer garg2_compName has been updated |
      #only Intro-date ( in past)
      | garg3_compName | 2016-08-30 |            | Success:Done! Computer garg3_compName has been updated |
      #Intro-date ( in past) and Discn date in past
      | garg3_compName | 2016-08-30 | 2016-08-31 | Success:Done! Computer garg3_compName has been updated |
      #Intro-date ( in past) and Discn date in future
      | garg3_compName | 2016-08-30 | 2016-12-31 | Success:Done! Computer garg3_compName has been updated |
      #Discn date earlier then Intro Date ( Although this should have failed but it is passing in this application)
      | garg3_compName | 2016-12-31 | 2016-08-30 | Success:Done! Computer garg3_compName has been updated |

    Examples: positive scenario- Computer Name
      | name           | IntroDate  | DiscnDate  | msg                                                                                                                                                                                         |
      #Special Characters in CompName
      | ~@%^&()_+  | 2016-09-30 | 2016-10-05 | Success:Done! Computer ~@%^&()_+ has been updated                                                                                                                                       |
      #Very lengthy CompName
      |  SSSSSSSSSSSSHHHHHHHHHHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAKKKKKKKKKKKKKKKKKKAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGG^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$ | 2016-09-30 | 2016-10-05 | Success:Done! Computer SSSSSSSSSSSSHHHHHHHHHHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAKKKKKKKKKKKKKKKKKKAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGG^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$ has been updated |
      #Only numbers in CompName
      |      123456789 | 2016-09-30 | 2016-10-05 | Success:Done! Computer 123456789 has been updated                                                                                                                                           |
      #alphanumeric in CompName
      | sgarg123456789 | 2016-09-30 | 2016-10-05 | Success:Done! Computer sgarg123456789 has been updated                                                                                                                                      |
      #space in CompName
      | sgarg garg     | 2016-09-30 | 2016-10-05 | Success:Done! Computer sgarg garg has been updated                                                                                                                                          |
      #Duplicate Name
      | garg3_compName | 2016-08-30 |            | Success:Done! Computer garg3_compName has been updated                                                                                                                                      |

    Examples: negative scenario- Fields left Blank
      | name      | IntroDate  | DiscnDate  | msg   |
      #All Fields blanks
      | blank     | blank      | blank      | Error |
      #Name as blank
      | blank     | 2016-08-30 | 2016-08-31 | Error |
      #both dates blanks
      | garg_edit | blank      | blank      | Error |
      #Intro date blank
      | garg_edit | blank      | 2016-08-30 | Error |
      #Disc dates blank
      | garg_edit | 2016-08-30 | blank      | Error |

    Examples: negative scenario- Wrong date format
      | name      | IntroDate  | DiscnDate  | msg   |
      #Intro date - wrong format
      | garg_edit | wrongdate  | 2016-08-30 | Error |
      #Dicn date - wrong format
      | garg_edit | 2016-08-30 | wrongdate  | Error |
      #both dates- wrong format
      | garg_edit | wrongdate  | wrongdate  | Error |
      #Intro date - wrong format
      | garg_edit | 30-30-2016 | 2016-08-30 | Error |
      #Dicn date - wrong format
      | garg_edit | 2016-08-30 | 30-30-2016 | Error |
