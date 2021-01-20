/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;
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
    String uiActor =
        OnStage.theActor(Constantes.MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    ActorData actorData = OnStage.theActor(uiActor).recall(SessionVariables.DATA_ACTOR.name());

    String token = OnStage.theActor(AUTHENTICATION_ACTOR).recall(SessionVariables.TOKEN.name());

    Map<String, Object> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("transaction-id", "5510241587652313827");
    headers.put("authorization-token", token);
    headers.put("x-adl-document-type", actorData.getDocumentType());
    headers.put("x-adl-document-number", actorData.getDocumentNumber());

    actor.attemptsTo(
        Get.resource(path).with(requestSpecification -> requestSpecification.headers(headers)));
  }
}
