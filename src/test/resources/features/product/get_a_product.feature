Feature: Get A Product

  Scenario: Validate to get a product functionality with product id

    Given The user is on the correct Base URI
    When The user sends a GET request to get a product endpoint with productId as 6483
    Then The response status code should be status code as 200

    When The user sends a GET request to get a product endpoint with productId as 1111
    Then The response status code should be status code as 404