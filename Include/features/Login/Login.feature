Feature: Login feature
  This is a login feature

  @valid_admin
  Scenario Outline: Login with valid username and password
    When User opens The Browser
    Then navigates to Home Page
    When click a masuk menu
    Then navigates to Login Page
    When input a valid <username> and <password>
    And click a masuk button
    Then navigates to The Dashboard Page Admin

    Examples: 
      | username | password |
      | admin01  | 12345678 |

  @valid_student
  Scenario Outline: Login with valid username and password
    When User opens The Browser
    Then navigates to Home Page
    When click a masuk menu
    Then navigates to Login Page
    When input a valid <username> and <password>
    And click a masuk button
    Then navigates to The Dashboard Page Student

    Examples: 
      | username | password |
      | student  | 12345678 |

  @invalid
  Scenario Outline: Test login failed feature
    When User opens The Browser
    Then navigates to Home Page
    When click a masuk menu
    Then navigates to Login Page
    When input a invalid <username> and <password>
    Then still in Login Page

    Examples: 
      | username | password |
      | salah    | salah    |
      | salah    | [blank]  |
      | [blank]  | salah    |
      | [blank]  | [blank]  |
