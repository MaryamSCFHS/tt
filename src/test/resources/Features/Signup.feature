Feature: Signup Functionality

  Scenario Outline: Check if signup is successful with valid fields
    Given browser is open
    When user is on signup page
    And user enters <FirstName> <LastName> <Email> <ConfirmEmail> <Password> <ConfirmPassword>
    And user clicks terms and conditions checkbox


    Examples: 
      | FirstName | LastName | Email      | ConfirmEmail | Password      | ConfirmPassword |
      | Test      | Test     | M@Test.com | M@Test.com   | aaaassdfgA12@ | aaaassdfgA12@   |


  Scenario Outline: Check if signup is not successful with invalid fields
    Given browser is open
    When user is on signup page
    And user enters <FirstName> <LastName> <Email> <ConfirmEmail> <Password> <ConfirmPassword>
    Then error masseage will apear under every invalid field
    Then user can not click signup button

    Examples: 
      | FirstName | LastName | Email | ConfirmEmail | Password | ConfirmPassword |
      |         3 |        5 | gg    | sf           | w        | m               |
