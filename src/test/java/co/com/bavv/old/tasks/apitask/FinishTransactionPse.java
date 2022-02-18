/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishTransactionPse implements Task {

  public static Performable put() {
    return instrumented(FinishTransactionPse.class);
  }

  @Override
  @Step("{0} obtiene obtiene el stado de la transaccion pse")
  public <T extends Actor> void performAs(T actor) {

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.AUX_ENV)));

    actor.attemptsTo(
        CallPutWith.token("pse-services"),
        Ensure.that(
            "Se valida el estado de la finaizacion de pse",
            validatableResponse -> validatableResponse.statusCode(200)));
  }
}
