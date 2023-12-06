Feature: This feature will allow you to create checklist for PC1 applicaiton with Birth Certificate as supporting document. 
Background: 
Given I enter valid username as "sanprathi@gmail.com" and password as "Vimalprabhu-202310" 
When I click login 
Then user is logged in Successfully 

@tag1
Scenario: Generate PC1 application with Birth Certificate as supporting document.
Given I click Start renewal/passport
And I read test data for testcase for "PC1_BirthCertificate"
When I select logement location as "Australia"
And I apply for a "Adult" application 
And I select that I am completing the application for "Myself" 
And I enter personal details 
And I enter contact details 
And I enter previous passport details 
And I choose Do you have Australian Birth Certificate as "Yes"
And I choose Is your BirthCertificate is an extract or a commemorative Certificate as "No"
And I choose Does your BirthCertificate show your parents name,age DOB "Yes"
And I enter Birthcertificate details
And I choose Do you have an Austraial Citizenship Certificate as "Yes"
And I enter Citizenshipdetails
And I confirm Identity
And I confirm Referee details
And I enter Emergency contact details
And I confirm Passport fees "A$325.00"
And I review application 
Then I can confirm that PC1 applicaiton is launched successfully
