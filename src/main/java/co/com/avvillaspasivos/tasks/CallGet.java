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
import co.com.avvillaspasivos.model.HeaderData;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import co.com.avvillaspasivos.util.UtilWs;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;
import static co.com.avvillaspasivos.util.Constantes.TRANSACTION_ID_VALUE;
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
        OnStage.theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    ActorData actorData = OnStage.theActor(uiActor).recall(SessionVariables.DATA_ACTOR.name());

    String token = OnStage.theActor(AUTHENTICATION_ACTOR).recall(SessionVariables.TOKEN.name());

    HeaderData headerData =
        HeaderData.builder()
            .transactionId(TRANSACTION_ID_VALUE)
            .documentNumber(actorData.getDocumentNumber())
            .documentType(actorData.getDocumentType())
            .build();

      Map<String, Object> mapHeaders= UtilWs.getHeaders(headerData);

      mapHeaders.put("authorization-token", token);

      actor.attemptsTo(
        Get.resource(path)
            .with(
                requestSpecification -> requestSpecification.headers(mapHeaders)));
  }
}
