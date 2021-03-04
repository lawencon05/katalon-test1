Feature: Login feature
  This is a sample login feature

  @success
  Scenario Outline: Test login success feature
    Given User open browser and navigates to Login Page
    When User input "<username>" and "<password>"
    Then System validates it and User navigates to Home Page

    Examples: 
      | username | password |
      | admin01  | 12345678 |

  @failed
  Scenario Outline: Test login failed feature
    Given User open browser and navigates to Login Page
    When User input "<username>" and "<password>"
    Then System validates it and User navigates to Home Page

    Examples: 
      | username | password |
      | name2    |        7 |
      | name2    |          |
      |          |        7 |
      |          |          |
