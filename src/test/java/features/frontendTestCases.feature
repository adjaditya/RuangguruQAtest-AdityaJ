@Frontend @SearchBar
Feature: Skill Academy's main search bar test cases

  Background: User is already in Skill Academy's main page
    Given User is in Skill Academy's main page

  @Smoke
  Scenario: User have to see the search bar in the main page
    Then Verify that the search bar is visible

  @Sanity
  Scenario: User searches using a basic search query
    When User searches with query "business"
    Then Verify that the search bar is visible
    And Verify that there are 20 results visible
    When User change the page results count to 50
    And Verify that there are 50 results visible