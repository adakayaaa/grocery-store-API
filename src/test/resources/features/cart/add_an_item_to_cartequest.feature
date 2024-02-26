Feature: Add an item to cartequest

  Scenario:Validate to add an item to cartequest functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    And The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 2 and specific cart id
    Then The response status code should be status code as 201