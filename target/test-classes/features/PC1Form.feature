Feature: This feature will allow you to create checklist for PC1 applicaiton. 
Background: 
Given I enter valid username as "sanprathi@gmail.com" and password as "Vimalprabhu-202310" 
When I click login 
Then user is logged in Successfully 

@tag1
Scenario: Successful Login with Valid Credentials
Given I click Start renewal/passport
And I read test data for testcase for "PC1_CitizenshipCertificate"
When I select that I am completing the application for "Myself" 
And I enter personal details 
And I enter contact details 
And I enter previous passport details 
And I choose Do you have Australian Birth Certificate as "No"
And I choose Do you have an Austraial Citizenship Certificate as "Yes"
And I enter Citizenshipdetails
And I confirm Identity
And I confirm Referee details
And I enter Emergency contact details
And I confirm Passport fees
And I review application and click Next
Then I can confirm that PC1 applicaiton is launched successfully
