Feature: Borrow Amount As an customer I want to Check how much I can borrow

 Scenario Outline: How much I can borrow
  	Given Launch the application
  	When I click the "application_type_single"
  	And I select the "dependants" with "<NoOfDependents>"
  	When I click the "borrow_type_home"
  	And I fill the "Your annual income" with "<Income>"
    And I fill the "other income" with "<OtherIncome>"
    And I fill the "living expenses" with "<LivingExpenses>"
    And I fill the "repayments" with "<Repayment>"
    And I fill the "Other loan" with "<OtherRepayment>"
    And I fill the "commitments" with "<Commitments>"
    And I fill the "credit card limits" with "<TotalCCLimit>"
    When I click the "btnBorrowCalculater"
    Then Validate the estimate amount
    When I click the Start Over
    Then Validate the fields empty  
    Then Close the browser
    
    Examples:
      | NoOfDependents | PropertyPurpose | Income | OtherIncome | LivingExpenses | Repayment | OtherRepayment | Commitments | TotalCCLimit | ButtonName |   
    	| 0 						 | Home to live in | 80000  | 10000       | 500            | 0         | 100            | 0           | 10000        | How much I could borrow | 
  	
Scenario Outline: Validte the error message
		Given Launch the application
  	And I fill the "living expenses" with "<LivingExpenses>"
  	When I click the "btnBorrowCalculater"
  	Then Validate the error message  
  	Then Close the browser
    
    Examples:
    | LivingExpenses |
    |	1							 |