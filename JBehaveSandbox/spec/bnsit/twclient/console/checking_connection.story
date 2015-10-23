Checking connection

Narrative:
As a user
I want to connect to twitter service
So that I can use system using console client
					 
Scenario:  Successful connection
Given there is a connection to twitter service
When I start an application
Then I can see "Connected." message

Scenario:  Not successful conneciton
Given there is no connection to twitter service
When I start an application
Then I can see "Not connected." message
