Feature: Select random closes and make checkOut.
  As a user.
  I want to Select closes.
  I want to do checkout.

  Background: User Log In To webApp
    Given Open Login URL Of E-Shop
    And LogIn To E-Shop

  Scenario: Select random closes and make checkOut.
    Given User Navigate to Dresses page.
    And Select first Random dresses.
    And Select second Random dresses.
    And Proceed to checkout.
    And Click continue at summary Page.
    And Verification & Compare Delivery and Billing Address.
    And Click Continue Button.
    And Select Agree And Click Submit button.
    And Select Payment Method (Check).
    And Verification of success order.
    And Click to Order History List.
    Then Verification and print last order prise.