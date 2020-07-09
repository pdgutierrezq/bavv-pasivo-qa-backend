/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Schema implements Task {
  private final String path;

  public Schema(String path) {
    this.path = path;
  }

  public static Performable validation(String path) {
    return instrumented(Schema.class, path);
  }

  @Step("Se realiza validacion del esquema de  #path")
  public <T extends Actor> void performAs(T actor) {

    JsonSchemaFactory jsonSchemaFactory =
        JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(
                ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze())
            .freeze();
    actor.attemptsTo(
        Ensure.that(
            "the json schema is correct",
            response ->
                response.body(matchesJsonSchemaInClasspath(path).using(jsonSchemaFactory))));
  }
}
