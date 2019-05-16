@feedback
Feature: TestCafe Feedback
  As a user,  I want to give feedback to TestCafe, so they will know my feedback

  Scenario: user input with valid data
    Given i open browser with url "https://devexpress.github.io/testcafe/example/"
    When i enter name as "Ibnuh hazar" in "developer-name"
    And i checklist important feature as Support for testing on remote device in "remote-testing"
    And i chose primary operating system as MacOS in "macos"
    And i select as TestCafe interface "JavaScript API" in "preferred-interface"
    And i checklist as I have tried TestCafe in "tried-test-cafe"
    And i give rate as "3" in "slider"
    And i give rate as "9" in "slider"
    And i give rate as "4" in "slider"
    And i give rate as "3" in "slider"
    And i give rate as "1" in "slider"
    And i give rate as "5" in "slider"
    And i give rate as "6" in "slider"
    And i give rate as "7" in "slider"
    And i give rate as "8" in "slider"
    And i enter comments as "Hello " in "comments"
    And I click "submit-button"   
    Then I verify "article-header" is "Thank you, Ibnuh hazara!"

  Scenario: user input without username
    Given i open browser with url "https://devexpress.github.io/testcafe/example/"
    When i checklist important feature as Support for testing on remote device in "remote-testing"
    And i chose primary operating system as Linux in "linux"
    And i select as TestCafe interface "Both" in "preferred-interface"
    And i checklist as I have tried TestCafe in "tried-test-cafe"
    And i give rate as "9" in "slider"
    And i give rate as "4" in "slider"
    And i give rate as "3" in "slider"
    And i give rate as "1" in "slider"
    And i give rate as "5" in "slider"
    And i give rate as "6" in "slider"
    And i give rate as "7" in "slider"
    And i give rate as "8" in "slider"
    And i enter comments as "Hello " in "comments"
    Then i verify "submit-button" is not clickable
