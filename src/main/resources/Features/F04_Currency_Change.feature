@SmokeTest

  @Currency

Feature: user can change Website Currencies between [$, €]

    # 1 Test case "Scenario"
  Scenario: switch Currency from $ To €

    Given user navigate to home page
    And select €

    Then € currency is selected


    # 2 Test case "Scenario"
  Scenario: switch Currency from € To $

    Given user navigate to home page
    And select US Dollar

    Then $ currency is selected
