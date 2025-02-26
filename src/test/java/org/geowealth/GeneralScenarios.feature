Feature: Main test cases related to site for re-selling cars

  Background: Navigate to the home page
    Given I load "Home" page
    * I click on "Приемане на бисквитките"
    * I click on "Автомобили и Джипове"
    * I click on "Само в България"

  Scenario: Verify specific job availability
    Given I click on "Търсене"
    When I search for a vehicle with the following criteria
      | brand | model | extras       |
      | VW    | Golf  | 4x4, 7 места |
    Then the results will be printed out


