/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CallPost implements Task {

  private final String path;
  private final Object body;

  public CallPost(String path, Object body) {
    this.path = path;
    this.body = body;
  }

  public static Performable pathBody(String path, Object body) {
    return instrumented(CallPost.class, path, body);
  }

  @Override
  @Step("{0} llama servicio Post")
  public <T extends Actor> void performAs(T actor) {
    String mainActor = theActorCalled(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    ActorData actorData = OnStage.theActor(mainActor).recall(SessionVariables.DATA_ACTOR.name());

    actor.attemptsTo(
        Post.to(path)
            .with(
                requestSpecification ->
                    requestSpecification
                        .header("Content-Type", "application/json")
                        .header("transaction-id", Constantes.TRANSACTION_ID_VALUE)
                        .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                        .header("x-adl-document-type", actorData.getDocumentType())
                        .header("x-adl-document-number", actorData.getDocumentNumber())
                        .body(body)));
  }
}
