#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Application Login
  I want to login
  
//the Before functions in hooks will execute first
  
//execute this after Before annotation methods in hooks and before every scenario 
#Background:
#Given ...
#When ...
#Then ...

#Before>Background>Scenario>After

@RegressionTest @NetBanking
  Scenario Outline: login scenario
    Given User in on NetBanking landing page
    When User login into application with "<username>" and "<password>"
    Then Home page is displayed
    And Cards are displayed
    
Examples:
| username   | password |
| debitUser  | hello123 |
| creditUser | lpo123   |

@SmokeTest @Mortgage
 Scenario Outline: sign up scenario
    Given User in on Mortgage landing page
    When User fill in application fields
    |Ahmed|
    |Belghith|
    |Ahmed.belghith@gmail.com|
    |123123| 
    Then Home page is displayed
    And Cards are displayed
    
    
