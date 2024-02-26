Feature: Modify An Item In The Cart

  Scenario: Validate to modify an item functionality

    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a PATCH request to get a cart endpoint with specific cart id with quantity as 2
    Then The response status code should be status code as 204

