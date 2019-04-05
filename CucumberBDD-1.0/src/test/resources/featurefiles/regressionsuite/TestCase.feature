Feature: Register Application 

Background:
	Given User is log in to the toolsQA application 
@regression	
Scenario Outline: Register as new user to toolsQA Application 
	When User enters valid personal information from "<TestData>" 
	And User clicks the submit button 
	Then User validate the success message
	
	Examples: 
		|TestDataPath|TestData|
		|src\main\resources\testdata\TestData.xlsx|TestCase01|
	#	|src\main\resources\testdata\TestData.xlsx|TestCase02|