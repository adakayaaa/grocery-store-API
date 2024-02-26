Feature: Delete An Item In The Cart
  Scenario: Validate to delete an item functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a POST request to add an item to cartequest endpoint with productId as 4646 and quantity as 1 and specific cart id
    And The user sends a DELETE request to get a cart endpoint with specific cart id with specific item id
    Then The response status code should be status code as 204

    When The user sends a GET request to get a cart endpoint with specific cart id
    Then The response should contains that items that added in cart following:
      | productId | 6483 |
      | quantity  | 1    |