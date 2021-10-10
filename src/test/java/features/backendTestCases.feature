@Backend @SearchBar
Feature: Skill Academy's main search bar API test cases

  @Sanity
  Scenario: Basic search using the "business" query
    When User GET search results with query "program"
    Then Verify that API call was successful with code 200
    And Verify results count is accurate
    And Verify user is in page 1
    And Verify status and message says success

  @Regression
  Scenario: Search where the result will return empty data
    When User GET search results with query "abcde"
    Then Verify that API call was successful with code 200
    And Verify results count is accurate
