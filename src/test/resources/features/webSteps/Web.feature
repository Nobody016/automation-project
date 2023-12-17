Feature: Web

  Scenario: First test
    Given Navigate to url "https://demoqa.com/"
    And Click on web object "//div[@class='card-body'][.//h5[text()='Elements']]"
#    And Click on web object "//*[@id='item-4'][.//span[text()='Buttos']]"
#    And Click on web object "//button[text()='Click Me']"
#    And Wait for "5" seconds
  
  Scenario: sadjasd
    Given Navigate to url "https://www.pcloudy.com/blogs/handling-iframes-in-selenium-based-test-automation/"
    And Wait for "10" seconds
    And Click on web object "//*[@data-test-id='chat-widget-launcher']"
    And Wait for "5" seconds

    Scenario: Testdsda
      Given Navigate to url "https://www.pcloudy.com/blogs/handling-iframes-in-selenium-based-test-automation/"
      And Clicks on web object "//*[@data-test-id='chat-widget-launcher']" using JavaScript