@SmokeTest

    @WishList

Feature: User could add items to wishlist

  Background:
    Given Open Browser
    And user open CellPhone

    #Scenario 1 Add HTC_M8 To wish list
  Scenario: user could add HTC_M8 Mobile to wishlist

    When Add HTC ONE M8 phone to Wish List
    Then Notification success message should be displayed
    And Notification success message color is green
    And HTC ONE M8 phone should be added to WishList Page
    And user add one HTC_M8 phone, the count increased


   #Scenario 2 Add HTC_Mini To wish list
  Scenario: user could add HTC_Mini Mobile to wishlist

    When Add HTC One Mini Blue phone to Wish List
    Then Notification success message should be displayed
    And Notification success message color is green
    And HTC One Mini Blue phone should be added to WishList Page
    And user add one HTC_Mini phone, the count increased