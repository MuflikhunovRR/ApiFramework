Feature: Get actors
  get the list of actors

  Scenario Template: : Sent request for getting actors

    Given Get Artists "<URL>" Request
    Then Response code is: <status>
    Examples:
      | URL         | status |
      | actors.json | 200    |
      |             | 403    |
      | wrong.json  | 404    |