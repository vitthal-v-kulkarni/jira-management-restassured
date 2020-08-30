Feature: Open Demand Deposit Bank Account

Scenario: Get Jira Session ID

	Given Payload is created
	When User triggers Authentication URL
	Then SessionID should be generated successfully