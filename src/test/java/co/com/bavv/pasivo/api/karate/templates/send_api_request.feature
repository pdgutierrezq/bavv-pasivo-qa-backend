Feature: API Request

  Scenario Outline: Send request
    When call read(SCRIPT.REST.POST.FROM.CSV) { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}

    Examples:
      | headersPath                           |
      | classpath:schemas/pasivo/headers.json |
