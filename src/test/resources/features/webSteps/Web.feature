Feature: Web

  Scenario: First test
    Given Navigate to url "https://demoqa.com/"
    And Click on web object "//div[@class='card-body'][.//h5[text()='Elements']]"
    And Click on web object "//*[@id='item-4'][.//span[text()='Buttons']]"
    And Click on web object "//button[text()='Click Me']"
    And Wait for "5" seconds