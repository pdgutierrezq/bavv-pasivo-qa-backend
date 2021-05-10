/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClientAccountsApi implements Task {

  private final int amount;

  public ClientAccountsApi(int amount) {
    this.amount = amount;
  }

  public static Performable post(int amount) {
    return instrumented(ClientAccountsApi.class, amount);
  }

  @Override
  @Step("{0} realiza el llamado del servicio customer accounts cdt")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData =actor.recall(SessionVariables.DATA_ACTOR.name());

    actor.whoCan(CallAnApi.at(ServicePaths.getCustomerAccountsEndPointBase()));

    actor.attemptsTo(
        Post.to(ServicePaths.pathCustomerAccountsCdt())
            .with(
                requestSpecification ->
                    requestSpecification
                        .header("Content-Type", ContentType.JSON)
                        .header("transaction-id", "5641016020193")
                        .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                        .header("x-adl-document-type", actorData.getDocumentType())
                        .header("x-adl-document-number", actorData.getDocumentNumber())
                        .body(buildCustomerAccountBody(amount))));
  }

  private String buildCustomerAccountBody(int amount) {
    return "{\"cdtAmount\": \""+amount+"\"}";
  }
}
