Feature: Search and Place the order for Products
  I want to Search and Place the order for Products

 @Exercice1
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenCart Landing page
    When User searched with ShortName <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And validate product name in offers page matches with Landing page
    
    Examples:
    |Name|
    |Tom |
    |Beet|
