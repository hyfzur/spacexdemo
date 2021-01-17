Feature: Space X - https://api.spacexdata.com/v4/launches/latest

  Scenario: Verify that the response code is "200"
    When User hits the api endpoint
    Then User should get the response code "200"

  Scenario: Verify that the date precision value is "hour"
    When User hits the api endpoint
    Then User should get the date precision as "hour"

  Scenario: Verify that the local launch time with time zone offset is in ISO 8601 format
    When User hits the api endpoint
    Then User should get the rocket, ships, capsules, payloads