Feature: API Get

  Scenario Outline: Get Request
    When call read(SCRIPT.REST.GET.FROM.JSON) { path: '#(path)', headersPath: '#(headersPath)'}

    Examples:
      | headersPath                           |
      | classpath:schemas/pasivo/headers.json |
