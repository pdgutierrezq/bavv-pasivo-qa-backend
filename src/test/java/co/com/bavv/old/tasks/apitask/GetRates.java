/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetRates implements Task {
  public static Performable callGet() {
    return instrumented(GetRates.class);
  }

  @Override
  @Step("{0} obtiene el listado de tasas")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Get.resource("get-cdt-rates"));
  }
}
