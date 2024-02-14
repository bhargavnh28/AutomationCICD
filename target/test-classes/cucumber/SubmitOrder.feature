
@tag
Feature: Purchase the Order from ECommerce Website
  I want to use this template for my feature file

	#Basically Before test Methhod

	Background:   
	Given I landed on Ecommerce Website

  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then  "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name  								 | password			| productName | status |
      | bhargavanh28@gmail.com | Goutham@99 | ZARA COAT 3 | THANKYOU FOR THE ORDER. |
      
