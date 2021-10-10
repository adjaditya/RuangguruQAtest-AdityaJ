@Frontend @SearchBar
Feature: Skill Academy's main search bar test cases

  Background: User is already in Skill Academy's main page
    Given User is in Skill Academy's main page

  @Smoke
  Scenario: User have to see the search bar in the main page
    Then Verify that the search bar is visible

  @Sanity
  Scenario: User searches using a basic search query and going to the second page
    When User searches with query "business"
    Then Verify that the search bar is visible
    And Verify that there are 20 results visible
    When User change the page results count to 50
    And Verify that there are 50 results visible

  @Sanity
  Scenario: User searches using a query with no results
    When User searches with query "abcdef"
    And Verify that there are 0 results visible
    And Verify that empty results screen is shown

  @Sanity
  Scenario: User going to the second page
    When User searches with query "business"
    And User goes to the next page
    Then Verify that user is in page 2

  @Regression
  Scenario: User searches using a query with less than 20 results
    When User searches with query "test automation"
    Then Verify that there are 20 results visible

