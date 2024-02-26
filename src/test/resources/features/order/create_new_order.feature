Feature: Create A New Order

  Background:
    Given The user is on the correct Base URI
    When I send a POST request client name as "abcdefgh" and client email as "abcdefgh@gmail.com" to the registration endpoint
    Then The response status code should be status code as 201

  Scenario: Validate to create a new order functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    Then The response status code should be status code as 201

    When The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a POST request to create a new order endpoint with specific cart id and customer name as "inar academy"
    Then The response status code should be status code as 201
    And The response should has a order id
