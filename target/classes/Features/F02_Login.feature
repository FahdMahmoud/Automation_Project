@SmokeTest

  @Login

Feature: user should be able to login to the System

  // here we can hold all repeated steps to be written ones
  // This two steps are executed before any test case
  Background:
    Given user open the browser
    And  user navigate to the login page

  # Test scenario 1
  Scenario: User login with valid User name and password

    # any actions inside login used with ( when )
    When user enter Valid Data vaild Email is "fahd.tiger2022@gmail.com" , valid Password is "123456"

   # When  user enter "fahd.tiger202@gmail.com" and "123456"
     And  user click on login button

    # Expected result
    Then  user could login successfully
     And  user directed to the home page




    # test scenario 2
    Scenario: User login with invalid user name , password

    # actions inside login
      When user enter Invalid Login Data inavlid email is "fahd@gmail.com" , invalid Password is "123456"
      And  user click on login button
    # Expected result
      Then  user could Not login successfully

