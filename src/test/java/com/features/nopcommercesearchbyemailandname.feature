Feature: Search customer by emailID and firstname

Scenario: search by email

Given when admin click customer menu
When select customer option from menu tree
And Search customer by email
And click search
Then validate the customer info

Scenario: Search by firstname

Given when admin click customer menu
When select customer option from menu tree
And Search customer by firstname
And click search
Then validate the customer info