Feature: User Registration

 Scenario Outline:Successful registration with valid credentials

    Given The user is on the correct Base URI
    When I send a POST request client name as "<client name>" and client email as "<client email>" to the registration endpoint
    Then The response status code should be status code as <status_code>
    And I receive a token in the response
    Examples:
      | client name | client email   | status_code |
      | ada9kaya    | ada9@gmail.com | 201         |

 Scenario:Unsuccessful registration with invalid credentials

   Given The user is on the correct Base URI
   When I send a POST request client name as "inrAcademy" and client email as 20 to the registration endpoint
   Then The response status code should be status code as 400



