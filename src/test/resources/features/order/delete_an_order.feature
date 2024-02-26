Feature: Delete An Order

  Background:
    Given The user is on the correct Base URI
    When I send a POST request client name as "ada1" and client email as "ada1@gmail.com" to the registration endpoint
    Then The response status code should be status code as 201

  Scenario: Validate to delete an order functionality

    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    And The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a POST request to create a new order endpoint with specific cart id and customer name as "inar academy"
    And The user sends a DELETE request to delete an order endpoint with specific orderId

    Then The response status code should be status code as 204

    When The user sends a GET request to get a single order endpoint with specific orderId
    Then The response status code should be status code as 404
