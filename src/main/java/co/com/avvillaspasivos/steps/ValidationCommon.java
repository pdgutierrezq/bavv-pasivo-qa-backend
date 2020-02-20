/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.steps;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidationCommon {
  private ValidationCommon() {
    throw new IllegalStateException("Utility class");
  }

  @Step("se valida el esquema {0} ")
  public static void validateSchema(String path) {
    JsonSchemaFactory jsonSchemaFactory =
        JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(
                ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze())
            .freeze();

    SerenityRest.then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath(path).using(jsonSchemaFactory));
  }
}
