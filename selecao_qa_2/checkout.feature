
Feature: Checkout

	As a user of the Amazon.com
	I want to able to do a purchase
	So that I can buy the product that I want
	
Scenario: Checkout with correct information 

	Given I have added an item to my cart 
	And I click the cart icon
	When I proceed to check out
	And I select a payment method
	And I enter valid details
	And I click continue button
	And confirm my order
	Then I am redirected to the thank you page with the number of the order


Scenario: Checkout with incorrect information

	Given I have added an item to my cart
	And I click the cart icon
	When I proceed to check out
	And I select a payment method
	And I enter invalid details
	And the continue button is disable
	