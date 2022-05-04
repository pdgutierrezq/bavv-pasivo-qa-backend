/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.data.DataProvider;
import co.com.bavv.old.facts.Usuario;
import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.ClientConditions;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

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
    ClientConditions conditions = ActorActions.buildActorConditions(userType);

    ActorData actorData = DataProvider.getActorData(conditions);

    actor.remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    actor.has(Usuario.informacion());
  }
}
