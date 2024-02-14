
@tag
Feature: Error Validation
  I want to use this template for my feature file

	Background:   
	Given I landed on Ecommerce Website

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I Landed on Ecommerce Page
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
