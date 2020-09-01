
Feature: Shopping Cart

	As a user of the Amazon.com
	I want to add products into my cart
	So that I can see the products and costs of what I want to buy

Scenario: Opening the shopping cart

	Given I have added an item to my cart 
	When I click the cart icon
	And I go to the shopping cart page
	Then I can see the product in my cart

Scenario: Adding a product to cart

	Given I have opened the product page 
	When I select the size/colour/quantity
   	And I click the add to cart button
   	Then the product is added to my cart