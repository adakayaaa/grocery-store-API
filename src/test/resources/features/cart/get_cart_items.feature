Feature: Get Cart Items

  Scenario:Validate to get cart items functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 4646 and quantity as 1 and specific cart id
    And The user sends a POST request to add an item to cartequest endpoint with productId as 4643 and quantity as 1 and specific cart id
    And The user sends a GET request to get cart items endpoint with specific cart id
    Then The response status code should be status code as 200

    And  The response information should match with added information of items to cartequest to following:
      | productId | quantity |
      | 4646      | 1        |
      | 4643      | 1        |

