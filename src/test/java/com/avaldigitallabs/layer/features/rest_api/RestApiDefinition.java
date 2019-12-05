/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.avaldigitallabs.layer.features.rest_api;

import com.avaldigitallabs.layer.features.rest_api.steps.RestApiSteps;
import com.avaldigitallabs.layer.utils.EnvironmentProperties;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RestApiDefinition {

    @Steps
    RestApiSteps jhon;

    String URL = "";


    @Given("the URL '(.*)'")
    public void the_url_is_ok(String url) {
        assertThat(url).isNotEmpty();
        URL = url;
    }

    @Given("the user want to Colombia URL")
    public void the_url_is_ok() {
        URL = EnvironmentProperties.getProperty("accounts.service.url");
        assertThat(URL).isNotEmpty();
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        jhon.readStatus(URL);
    }

    @Then("the API should return '(.*)'")
    public void the_API_should_return(String expectedMessage) {
        jhon.readContent(expectedMessage);

    }
}
