Feature: API Get

  Scenario: Get Request
    When call read(SCRIPT.REST.GET.BASIC) { path: '#(path)'}
