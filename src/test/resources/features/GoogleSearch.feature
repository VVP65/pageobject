Feature: Google search

  Scenario: Wikipedia homepage Google search
    Given I open Google home page
    When  I search Wikipedia
    Then  I can see Wikipedia home page address on the search result page