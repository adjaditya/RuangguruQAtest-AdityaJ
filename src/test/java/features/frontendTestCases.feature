@Frontend @SearchBar
Feature: Skill Academy's main search bar test cases

  Background: User is already in Skill Academy's main page
    Given User is in Skill Academy's main page



  @Smoke
  Scenario: User have to see the search bar in the main page
    Then Verify that the search bar is visible