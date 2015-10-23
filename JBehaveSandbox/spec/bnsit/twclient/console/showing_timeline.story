Showing timeline

Narrative:
As a user
I want to see the timeline
So that I am in touch with people I follow
					 
Scenario:  Showing first statuses of my timeline
Given I have started an application
When I enter "timeline"
Then I will see first 20 statuses
					 
Scenario:  Showing specific number of statuses
Given I have started an application  
When I enter "timeline 5"  
Then I will see first 5 statuses
