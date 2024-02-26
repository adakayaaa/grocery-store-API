Feature: Replace An Item In The Cart

  Scenario: Validate to replace an item functionality

    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a PUT request to get a cart endpoint with specific cart id with productId as 5774 and quantity as 1
    Then The response status code should be status code as 204

    When The user sends a GET request to get a cart endpoint with specific cart id
    Then The response should contains that items that added in cart following:
      | productId | 5774 |
      | quantity  | 1    |