Feature: Feature to Angular Practice Page Automation

@PracticepageRegistration
Scenario Outline: Submitting the registration page details

Given open the angular practice page "<url>"  
When Enter the vaild name "<name>" and email id "<email>" and password "<password>" 
When check the Check me out if you Love IceCreams checkbox
When Choose the Male option in Gender
When select the Employed radio button
When choose the vaild date of birth "<dob>"
Then click the submit button

Examples:

|url|name|email|password|dob|
|https://rahulshettyacademy.com/angularpractice/|Manoj|nvmanoj5@gmail.com|123|01/05/1995|

@Alertboxvalidate
Scenario Outline: Validating the alertbox in practice page

Given open the automation practice page "<url>" 
When Enter the name in alertbox "<name>"
Then Click the alert button

Examples:

|url|name|
|https://rahulshettyacademy.com/AutomationPractice/|Manoj|
