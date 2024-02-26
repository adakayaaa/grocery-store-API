Feature: Get All Orders

  Background:
    Given The user is on the correct Base URI
    When I send a POST request client name as "023" and client email as "1234567890235@gmail.com" to the registration endpoint
    Then The response status code should be status code as 201

  Scenario: Validate to get all orders functionality

    Given The user is on the correct Base URI

    When The user sends a POST request to create a new cart endpoint
    And The user sends a POST request to add an item to cartequest endpoint with productId as 6483 and quantity as 1 and specific cart id
    And The user sends a POST request to create a new order endpoint with specific cart id and customer name as "inar academy"
    And The user sends a POST request to add an item to cartequest endpoint with productId as 4643 and quantity as 1 and specific cart id
    And The user sends a POST request to create a new order endpoint with specific cart id and customer name as "inar academy"
    And The user sends a GET request to get all orders endpoint

    Then The response status code should be status code as 200
    And The customer name of response body should match customer name of request as "inar academy"
