/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.avaldigitallabs.layer.features.rest_api.steps;


import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.contains;

public class RestApiSteps {

    private Response response;

    @Step
    public void readStatus(String url) {

        response = SerenityRest.when().get(url);
        response.
            then().assertThat().statusCode(200);
    }

    @Step
    public void readContent(String expectedMessage) {
        response.
            then().body("RestResponse.result.name", contains(expectedMessage));
    }
}
