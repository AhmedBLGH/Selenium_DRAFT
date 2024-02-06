Feature: Search and Place the order for Products
  I want to Search and Place the order for Products

 @Exercice
  Scenario: Search Experience for product search in both home and offers page
    Given User is on GreenCart Landing page
    When User searched with ShortName "Tom" and extracted actual name of product
    Then User search for "Tom" in offers page to check if product exist
    And validate product name in offers page matches with Landing page
