Feature: add new customer in nopCommerce 

Background: 
	Given Browser launch and maximize browser 
	
Scenario Outline: admin login 

	Given admin landed on the nopcommerce login page using "https://admin-demo.nopcommerce.com/login" URL 
	When admin enter email "<email>" in the email field 
	And admin enter password "<password>" in the password field 
	And click login 
	
	Examples: 
		|email|password|
		|admin@yourstore.com|admin|
		
		
Scenario: add new customer 

	When admin navigates to nopcommerce dasboard page 
	And admin click customer menu 
	And select customers to add new customer 
	And click add new button 
	Then Admin navigates to the customer page 
	When add customer details 
	And click save 
	Then admin validate the customer information added successfully 
	And admin logout 
	
	
	
