Feature: Update Headers

  Scenario Outline: Update headers
    * def currentHeaders = read(headersPath)
    * def transaction_id = currentHeaders["transaction-id"]
    * def x_adl_channel = currentHeaders["x-adl-channel"]
    * def x_adl_document_type = currentHeaders["x-adl-document-type"]
    * def x_adl_document_number = currentHeaders["x-adl-document-number"]
    * call read(SCRIPT.REST.POST.FROM.JSON) { path: '#(path)', bodyTemplatePath: '#(bodyTemplatePath)', headersPath: '#(headersPath)'}
    * eval currentHeaders["authorization-token"] = response.userAccessToken.accessToken
    Then karate.write(currentHeaders,filePath)

    Examples:
      | headersPath                           | filePath                                   |
      | classpath:schemas/pasivo/headers.json | resources/test/schemas/pasivo/headers.json |
