@SmokeTest

  @Register


Feature: guest user could register with valid data successfully
  Scenario: user register with valid data

    Given user Open the browser to register
    And user navigate to Home page
    And user navigate to register page

    When user enter valid data, first name is "Fahd" , last name is "Mahmoud", email is "fahd.tiger2022@gmail.com", company is "FWD", password is "123456" and confirm password is "123456"
    And user click on Register Button

    Then user Registration Successfully



