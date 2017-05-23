Feature: Search of a product
  As a user
  I want to perform search of a product on the website by article number
  So that I could see correct search result

  Scenario: Check number of reviews and stars
    Given I am on the Main page
    When I search for a product by article number "5000299223017"
    Then I see number of reviews for this product is "50" and number of stars is "5"


