@Backend @SearchBar
Feature: Skill Academy's main search bar API test cases

  @Sanity
  Scenario: Basic search using the "business" query
    When User GET search results with query "program"
    Then Verify that API call was successful with code 200
    And Verify results count is accurate
    And Verify user is in page 1
    And Verify status and message says success

  @Sanity @Current
  Scenario Outline: Test <minOrMax> Price parameter
    When User GET search results with query business and 300000 <minOrMax> price
    Then Verify that all prices in the results satisfy <minOrMax> price condition for amount 300000

    Examples:
      | minOrMax |
      | min      |
      | max      |

  @Regression
  Scenario: Search where the result will return empty data
    When User GET search results with query "abcde"
    Then Verify that API call was successful with code 200
    And Verify results count is accurate