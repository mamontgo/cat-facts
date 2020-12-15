Feature: Verify the facts get service

  Scenario: client makes call to GET a fact to return all facts
    When the client calls for list /fact
    Then the client facts returned have a count of 45
