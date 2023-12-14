Feature: Application Login

  Scenario: Login with valid credentials
    Given Open any Browser
    And Navigate to Login page
    When User enters username as "nipuninuwanthi97@gmail.com" and password as "nuwanthi@5914" into the fields
    And User clicks on Login button
    Then Verify user is able to successfully login
    And User clicks on Logout button
    Then Verify user is able to successfully logout