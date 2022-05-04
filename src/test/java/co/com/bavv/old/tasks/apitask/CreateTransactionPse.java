/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.model.BodyCreateTransactionPse;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateTransactionPse implements Task {

  public static Performable post() {
    return instrumented(CreateTransactionPse.class);
  }

  @Override
  @Step("{0} crea una transaccion pse")
  public <T extends Actor> void performAs(T actor) {

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.DEV_ENV)));

    BodyCreateTransactionPse bodyCreateTransactionPse = getGenericBody();

    actor.attemptsTo(
        CallPostWith.token("pse-create-transaction", bodyCreateTransactionPse)

    );
    actor.attemptsTo(
        Ensure.that(
            "Se valida el estado de la crecion de pse",
            validatableResponse -> validatableResponse.statusCode(200))
    );

  }

  public static BodyCreateTransactionPse getGenericBody() {
    return BodyCreateTransactionPse.builder()
        .bankId("1022")
        .fee(140779710)
        .tax(0)
        .userType("0")
        .build();
  }
}
