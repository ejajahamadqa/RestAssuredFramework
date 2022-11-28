Feature: End User should be able to search the hotels

  Description: GET API from Hotels Module.

  @smoke_test @GET_API
  Scenario Outline: To verify the get Hotels
    Given "<City>" is added to the request
    When we hit the "get" request
    Then Verify the status code is 200
    And Verify the response
    |key               | value                |
    |locations.country | United Arab Emirates |
    |locations.country | Saudi Arabia         |

Examples:
    | City |
    | dubai  |
    | Saudi Arabia  |