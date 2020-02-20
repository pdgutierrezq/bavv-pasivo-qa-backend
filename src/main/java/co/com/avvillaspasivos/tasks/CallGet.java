/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallGet implements Task {
  private final String path;

  public CallGet(String path) {
    this.path = path;
  }

  public static Performable path(String path) {
    return instrumented(CallGet.class, path);
  }

  @Override
  @Step("{0} llama servicio GET")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource(path)
            .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)));
  }
}
