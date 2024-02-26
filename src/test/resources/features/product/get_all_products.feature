Feature: Get All Products

  Scenario: Validate get all products functionality
    Given The user is on the correct Base URI
    When The user sends a GET request to get all products endpoint with "category" as "coffee"
    Then The response status code should be status code as 200
    And The product's category should match with specified "coffee"