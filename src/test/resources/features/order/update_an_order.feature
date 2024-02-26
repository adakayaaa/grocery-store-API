Feature: Update An Order

  Background:
    Given The user is on the correct Base URI
    When I send a POST request client name as "ada12" and client email as "ada12@gmail.com" to the registration endpoint
    Then The response status code should be status code as 201

  Scenario: Validate to update an order functionality

    Given The user is on the correct Base URI
    When The user sends a POST request to create a new cart endpoint
    And The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a POST request to create a new order endpoint with specific cart id and customer name as "inar academy"
    And The user sends a PATCH request to update an order endpoint to customer name as "1234" with specific orderId

    Then The response status code should be status code as 204

    When The user sends a GET request to get a single order endpoint with specific orderId
    And The user should see customer name as expected as "1234"
