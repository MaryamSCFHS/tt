Feature: Login Functionality

  @Smoke
  Scenario Outline: Check if login is successful with valid credentials
    Given browser is open1
    And user is on login page
    When user enters <Email> and <password>

    #And user clicks login button
    #Then user navigated to dashboard page
    Examples: 
      | Email | Password |
      | Test  | Test     |

  @Smoke
  Scenario Outline: Check if login is not successful with invalid credentials
    Given browser is open1
    And user is on login page
    When user enters <Email> and <password>
    Then error masseage will apear under invalid field
    Then user can not click Login button

    Examples: 
      | Email | password |
      | Test1 | Test1    |
      | Test  | Test1    |
      | Test1 | Test     |
#both invalid
#password is invalid
#username is invalid
