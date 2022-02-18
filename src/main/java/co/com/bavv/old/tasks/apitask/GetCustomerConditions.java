/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.BodyWs;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCustomerConditions implements Task {

  public static Performable post() {
    return instrumented(GetCustomerConditions.class);
  }

  @Override
  @Step("{0} realiza el llamado del servicio condiciones cliente")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData = actor.recall(SessionVariables.DATA_ACTOR.name());

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

    BodyWs bodyWs = buildCustCondBody(actorData);

    actor.attemptsTo(
        Post.to(ServicePaths.pathCustomerConditions())
            .with(
                requestSpecification ->
                    requestSpecification
                        .header("Content-Type", ContentType.JSON)
                        .header("transaction-id", Constantes.TRANSACTION_ID_VALUE)
                        .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                        .header("x-adl-document-type", actorData.getDocumentType())
                        .header("x-adl-document-number", actorData.getDocumentNumber())
                        .body(bodyWs)));
  }

  private BodyWs buildCustCondBody(ActorData actorData) {
    return BodyWs.builder()
        .documentType(actorData.getDocumentType())
        .documentNumber(actorData.getDocumentNumber())
        .build();
  }
}
