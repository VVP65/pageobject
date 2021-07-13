Feature: BBC News search

  Background:
    Given I opened BBC News home page

  Scenario Outline: Searching news on BBC News page
    When I searched <news> and open new page
    Then I can see News page contains <text>

    Examples:
      | news      | text      |
      | ukraine   | Ukraine   |
      | germany   | Germany   |
      | england   | England   |


