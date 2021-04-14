/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BankList implements Task {

  public static Performable get() {
    return instrumented(BankList.class);
  }

  @Override
  @Step("{0} obtiene el listado de bancos")
  public <T extends Actor> void performAs(T actor) {
    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    actor.attemptsTo(CallGet.path("pse-get-bank-list"));
    List<String> bancos = SerenityRest.lastResponse().body().jsonPath().getList("name");
    bancos.remove(0);
    actor.remember(SessionVariables.BANK_LIST.name(), bancos);
  }
}
