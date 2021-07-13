/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.paths.ServicePaths;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.AUX_ENV;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPseStatus implements Task {

  public static Performable get() {
    return instrumented(GetPseStatus.class);
  }

  @Override
  @Step("{0} obtiene obtiene el stado de la transaccion pse")
  public <T extends Actor> void performAs(T actor) {

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(AUX_ENV)));

    actor.attemptsTo(
        CallGetWith.token("pse-services"));
    actor.attemptsTo(
        Ensure.that(
            "Se valida el estado de la validacion de estado pse",
            validatableResponse -> validatableResponse.statusCode(200)));
  }
}
