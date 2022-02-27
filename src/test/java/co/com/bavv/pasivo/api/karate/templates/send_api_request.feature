Feature: API Request

  Scenario Outline: Send request
    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path/post_with_files.feature') { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}

    Examples:
      | headersPath                           |
      | classpath:schemas/pasivo/headers.json |
