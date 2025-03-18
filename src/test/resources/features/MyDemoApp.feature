Feature: Checkout Process on MyRNDemo App
@ios
  Scenario: Checkout Process on MyRNDemo App on an iOS device

    Given The user launches the MyRNDemo App on an iOS device
    When The user selects the first product from the list
    And The user sets the quantity to 2
    And The user taps on "Add to Cart"
    And The user proceeds to the cart
    And The user login with email "bob@example.com" and password "10203040"
    And The user provides the shipping details:
      | Field          | Value          |
      | Full Name      | My Name        |
      | Address Line 1 | Street 123     |
      | City          | New York       |
      | Zip Code      | 10001          |
      | Country       | United States  |
    And The user presses "Proceed to Payment"
    Then The user verifies the presence of "Enter a payment method"
    And The user should find the "Review Order" button
    
@android
  Scenario: Checkout Process on MyRNDemo App on an Android device

    Given The user opens the MyRNDemo App on an Android device
    When The user navigates to the first item in the list
    And The user modifies the quantity to 2
    And The user clicks "Add to Cart"
    And The user navigates to the cart section
    And The user signin with email "bob@example.com" and password "10203040"
    And The user fills in the shipping details:
      | Field          | Value          |
      | Full Name      | My Name        |
      | Address Line 1 | Street 123     |
      | City          | New York       |
      | Zip Code      | 10001          |
      | Country       | United States  |
    And The user hits on "Go to Payment"
    Then The user should confirm the text "Enter a payment method" is displayed
    And The user should locate the "Review Order" button
