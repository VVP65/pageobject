Feature: Google search

  Scenario: Wikipedia homepage Google search
    Given I opened Google home page
    When  I searched 'Wikipedia'
    Then  I can see 'Wikipedia' home page address on the search result page