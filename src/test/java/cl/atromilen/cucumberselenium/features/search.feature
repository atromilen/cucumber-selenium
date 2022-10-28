Feature: Search
  As a user, I want to do a new search of articles

  Scenario Outline: Search articles
    Given the user is in the index page
    When the user enters <article> in the search bar
    And the user clicks the search button
    Then the <article> page appears showing <results> articles

    Examples:
      | article   | results |
      | "dresses" | 7       |
      | "blouses" | 1       |
      | "t-shirt" | 1       |
