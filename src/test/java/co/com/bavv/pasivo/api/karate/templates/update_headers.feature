Feature: Update Headers

  Scenario Outline: Update headers
    * def currentHeaders = read(headersPath)
    * def transaction_id = currentHeaders["transaction-id"]
    * def x_adl_channel = currentHeaders["x-adl-channel"]
    * def x_adl_document_type = currentHeaders["x-adl-document-type"]
    * def x_adl_document_number = currentHeaders["x-adl-document-number"]
    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path/post_with_files.feature') { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}
    * eval currentHeaders["authorization-token"] = response.userAccessToken.accessToken
    Then karate.write(currentHeaders,filePath)

    Examples:
      | headersPath                           | bodyTemplatePath                                                  | filePath                                   |
      | classpath:schemas/pasivo/headers.json | classpath:schemas/pasivo/user-identity/requests/validate-otp.json | resources/test/schemas/pasivo/headers.json |
