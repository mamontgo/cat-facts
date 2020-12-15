Feature: Verify the fact get service

  Scenario: client makes call to GET a fact with id 58e008ad0aac31001185ed0c
    When the client calls /fact with id 58e008ad0aac31001185ed0c
    Then the client fact has fact type cat
    And the client fact has user first name Kasimir
    And the client fact has user last name Schulz
    And the client fact has a vote count of 11

  Scenario: client makes call to GET a fact eith id 5b4911940508220014ccfe94
    When the client calls /fact with id 5b4911940508220014ccfe94
    Then the client fact has fact type cat
    And the client fact has user first name Alex
    And the client fact has user last name Wohlbruck
    And the client fact has a vote count of 7

