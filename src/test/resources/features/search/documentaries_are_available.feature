Feature: Documentaries are available

  As a user of ITV Hub
  I want to see a list of Factual programmes
  So that I can view the latest available documentaries

  Scenario: see a list of Factual programmes
    Given user has navigated to hub categories page
    When user selects Factual
    Then user should see a list of documentaries
    #And






