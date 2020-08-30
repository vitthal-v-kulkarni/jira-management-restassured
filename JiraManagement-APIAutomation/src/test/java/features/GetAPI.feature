Feature: To verify Jira GET Operations

Scenario: Verify Jira GET Api

	Given Payload is created
	When User triggers GET URL
	Then Jira issue should be retrieved successfully
	And Verify IssueType Name correctly retrieved
	And Verify IssueType Subtask correctly retrieved
	And Verify Project ID correctly retrieved
	And Verify Project Key correctly retrieved
	And Verify Project Name correctly retrieved
	And Verify Project TypeKey correctly retrieved
	And Verify Project Simplified correctly retrieved	
	