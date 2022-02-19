Feature: API Request

  Scenario Outline: Send request
    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path/post_with_files.feature') { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}

    Examples:
      | headersPath                           | bodyTemplatePath                                                  |
      | classpath:schemas/pasivo/headers.json | classpath:schemas/pasivo/create-passive-product/requests/cda.json |
