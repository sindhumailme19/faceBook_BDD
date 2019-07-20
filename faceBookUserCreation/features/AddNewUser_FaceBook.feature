Feature: Create New User 

@UserCreation 
Scenario: Facebook User Creation 
 
	Given User is already on Facebook Registration Page 
		|WorkBook   |Sheet              |ColumName      		|
		|TestData   |UserCreation       |RegistrationPageVerify | 
	When User enters all the mandatory registration fields 
		|WorkBook   |Sheet              |ColumName |
		|TestData   |UserCreation       |FirstName | 
		|TestData   |UserCreation       |SurName   | 
		|TestData   |UserCreation       |EmailAddress| 
		|TestData   |UserCreation       |NewPassword | 
		|TestData   |UserCreation       |BirthDate   | 
		|TestData   |UserCreation       |BirrthMonth | 
		|TestData   |UserCreation       |BirthYear   | 
		
	When User clicks on the Sign Up button 
	Then Facebook account successfully created 
		|WorkBook   |Sheet              |ColumName |
		|TestData   |UserCreation       |FirstName | 
		
@LoginTest 
Scenario: Facebook login scenrio with created User 
	Given User is already on Facebook Login Page 
		|WorkBook   |Sheet              |ColumName |
		|TestData   |UserCreation       |RegistrationPageVerify | 
		
	When User logged with created Username and Password 
		|WorkBook   |Sheet              |ColumName |
		|TestData   |UserCreation       |EmailAddress | 
		|TestData   |UserCreation       |NewPassword  | 
		
	When Click on log In button 
	Then User successfully logged with created Facebook user 
		|WorkBook   |Sheet              |ColumName |
		|TestData   |UserCreation       |FirstName | 
		
