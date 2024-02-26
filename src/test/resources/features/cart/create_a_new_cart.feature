Feature: Create a new cart

  Scenario:Validate to create a new cart functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201
