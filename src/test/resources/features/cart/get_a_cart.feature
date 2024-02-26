Feature: Get A Cart

  Scenario: Validate to get a cart functionality

    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 2 and specific cart id
    And The user sends a GET request to get a cart endpoint with specific cart id
    Then The response status code should be status code as 200
    And The response should contains that items that added in cart following:
      | productId | 6483 |
      | quantity  | 2    |
