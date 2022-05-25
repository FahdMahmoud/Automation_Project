@SmokeTest

  @Search

Feature: users will be able to search for products with different parameters

  Background:
    Given user Open the browser to search
    And user navigate to the Home page

  # Test Scenario 1
  Scenario: user could search using product name by click on search button

    When user write product name in the search Text box in the Home page product name is "Apple"
    And user Click on search button

    Then the application directed to the URL Successfully_ProductName
    And  product appeared

      # Test Scenario 2
  Scenario: user could search using product SKU by hit ENTER from Keyboard

    When user write product SKU in the search Text box in the Home page Product SKU is "AP_MBP_13"
    And user hit Enter from keyboard

    Then the application directed to the URL Successfully_SKU
    And  product appeared






