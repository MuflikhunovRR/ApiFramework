Feature: Get Weather

  Scenario Template: : Sent request for getting actors
    Given Get Weather "<city>" Request
    Then Weather Response code is: <status>
    Then Check Weather data in response
      | City                  | <city>           |
      | Temperature           | Degree celsius   |
      | Humidity              | Percent          |
      | Weather Description   | scattered clouds |
      | Wind Speed            | Km per hour      |
      | Wind Direction degree | Degree           |
    Examples:
      | city     | status |
      | gotoqa   | 200    |
      | new-york | 200    |