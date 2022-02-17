Feature: Update Headers

  Scenario Outline: Update headers
    * def currentHeaders = read(headersPath)
    * def transaction_id = currentHeaders["transaction-id"]
    * def x_adl_channel = currentHeaders["x-adl-channel"]
    * def x_adl_document_type = currentHeaders["x-adl-document-type"]
    * def x_adl_document_number = currentHeaders["x-adl-document-number"]
    * def body = { env: #(environment)}
    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path/post_with_files.feature') { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', body:'#(body)', headersPath: '#(headersPath)'}
    * eval currentHeaders["x-api-key"] = api_key
    * eval currentHeaders["custom-authorization"] = response.refreshToken.cognito.token.id_token
    * eval currentHeaders["access-token"] = response.refreshToken.cognito.token.access_token
    * def microsoftCookie = karate.pretty(response.refreshToken.cookies[0])
    Then karate.write(currentHeaders,filePath)

    Examples:
      | path | headersPath                           | bodyTemplatePath                                                  | filePath                                                    |
      |      | classpath:schemas/pasivo/headers.json | classpath:schemas/pasivo/user-identity/requests/validate-otp.json | resources/test/schemas/pasivo/headers.json |
