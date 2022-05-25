@SmokeTest

   @Hover

Feature: user could hover categories and select sub category

  Scenario: user could hover on categories and select subcategory

    Given user open browser
    And user navigate to home page to hover on category

    When user hover category and select subcategory
    And user select subcategory from main category

    Then user select the subcategory successfully

