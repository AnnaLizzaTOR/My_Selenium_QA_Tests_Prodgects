Feature: Fill & submitted Transfer Funds & PayBills form
  As a user.
  I want to fill all the fields.
  I can submit it.

Background: User Log In To webApp
  Given Open Login URL Of ZeroBank
  And LogIn To ZeroBank

  Scenario: Form Transfer Funds will all required fields can be submitted
  Given User navigate to section of Transfer Funds.
    And Form Account Line Random Select.
    And To Account Line Random Select.
    And Amount Line Random Input.
    And Description Line Random Input.
    And Click Continue Button.
    And Assert All Line Information.
    And Click Submit Button.
    Then Verification Message Of Successfully Submitted Form.

    Scenario: Form Pay Saved Payee Of Pay Bills Sector will all required fields can be submitted
      Given User navigate to section Pay Bills.
      And User navigate to section Pay Saved Payee.
      And Payee Line Random Select.
      And Account Line Random Select.
      And Amount Line Random Input_Pay Saved Payee.
      And Date Line Random Input.
      And Description Line Random Input_Pay Saved Payee.
      And Click Pay Button.
      Then Verification Message Of Successfully Payment Form.

      Scenario: Form Add New Payee Of Pay Bills Sector Will All Required Fields Can Be Submitted
        Given User navigate to section Pay Bills.
        And User navigate to section Add New Payee.
        And Payee Name Line Input.
        And Payee Address Line Input.
        And Account Line Input.
        And Payee Details Line Input.
        And Click Add Payee Button.
        Then Verification Message Of Successfully created new payee.
