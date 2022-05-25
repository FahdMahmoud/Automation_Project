@SmokeTest

  @Slider

Feature: users will be able to open sliders in home page

  Background:
    Given open browser
    And navigate to home_page

  # Scenario 1
  Scenario: first slider ( Nokia Lumia 1020 ) is clickable on home page


    When user click on first slider

    Then first slider item page opened successfully


      # Scenario 2
  Scenario: second slider ( iPhone ) is clickable on home page


    When user click on second slider

    Then second slider item page opened successfully