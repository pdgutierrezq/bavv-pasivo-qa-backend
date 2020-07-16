/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.ActorActions.buildActorConditions;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetFlowDataActor implements Task {
  private final String userType;

  public GetFlowDataActor(String userType) {
    this.userType = userType;
  }

  public static Performable type(String userType) {
    return instrumented(GetFlowDataActor.class, userType);
  }

  @Step("{0} se configura el tipo de usuario #userType")
  public <T extends Actor> void performAs(T actor) {
    ClientConditions conditions = buildActorConditions(userType);

    ActorData actorData = DataProvider.getActorData(conditions);

    actor.remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    actor.attemptsTo(BdUser.toBlock(true));

    actor.has(Usuario.informacion());
  }
}
