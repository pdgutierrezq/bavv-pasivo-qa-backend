/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apivalidation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.seleniumhq.jetty9.http.HttpStatus;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveSummaryResponse implements Task {

  public static Performable validate() {
    return instrumented(SaveSummaryResponse.class);
  }

  @Override
  @Step("{0} valida la información de la respuesta summary transaction")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Ensure.that(
            "Se valida estado de transcacion", response -> response.statusCode(HttpStatus.OK_200)));
  }
}
