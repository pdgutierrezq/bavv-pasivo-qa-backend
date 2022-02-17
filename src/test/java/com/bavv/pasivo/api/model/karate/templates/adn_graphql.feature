Feature: ADN Graphql

  Scenario Outline: ADN Graphql
    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path/post_with_files.feature') { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}

    Examples:
      | path     | headersPath                                            |
      | /graphql | classpath:schemas/adn/controllers/graphql/headers.json |
