@test
Feature: Careers Link


  Background: Common steps for all scenarios
      Given I am on the homepage

    Scenario:QA Automation Coding Test
      When I click the career link AND verify the url is "correct"
      And I search for a job "job" AND select it
      And I verify the job title "job title", location "job location", id "job id", requirements "requirements", programming language "programming language", and testing tool "testing tool"
      When I click the apply button
#      And I verify "job title", "job selection", "job id", "requirements"
#      Then I click to Return to Job Search




