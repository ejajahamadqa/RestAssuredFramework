Feature: End User should be able to search Chalets

  Description: POST API from Chalets Module.

  @POST_API
  Scenario: Load the Chalets Page
    Given Body is added to the post request
    When we hit the "post" request
    Then Verify the status code is 200
    And Verify the response
    |key                                            | value     |
    |currencyCode                                   | SAR       |
    |properties.priceDetail.hostPreApprovalRequired | false     |
