Feature: Search
  As a user, I want to do a new search of dresses

  Scenario: Search dresses
    Given the user is in the index page
    When the user type dresses in the search bar
    And the user clicks the search button
    Then the dresses page appears