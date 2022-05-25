@SmokeTest

  @Add_Cart

Feature: User could add items to Cart

  Background:
    Given Open Browser On HomePage
    And user open CellPhone page

       #Scenario 1 Add Nokia Lumia 1020 To Add To Cart
  Scenario: user could add Nokia Lumia 1020 Mobile to Cart

    When user click on AddToCart button Nokia Lumia 1020 phone
    Then Notification success message should be displayed when Add success
    And Notification success message color is green when Add success
    And Nokia Lumia 1020 phone should be added to cart Page successfully
    And user add another Nokia Lumia 1020 phone, the count should increased


       #Scenario 2 Add HTC_Mini To wish list
  Scenario: user could add HTC_Mini Mobile to Cart

    When user click on AddToCart button HTC One Mini Blue phone to Add cart
    Then Notification success message should be displayed when Add success
    And Notification success message color is green when Add success
    And HTC One Mini Blue phone should be added to Cart successfully
    And user add another HTC Mini phone, the count should increased