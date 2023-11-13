Feature: This feature will allow you to create checklist for PC1 applicaiton. 
Background: 
Given I enter valid username as "sanprathi@gmail.com" and password as "Vimalprabhu-202310" 
When I click login 
Then user is logged in Successfully 

@tag1
Scenario: Successful Login with Valid Credentials
Given I click Start renewal/passport
And I read test data for testcase for PC1
When I select that I am completing the application for "Myself" 
And I enter personal details 
And I enter contact details 

