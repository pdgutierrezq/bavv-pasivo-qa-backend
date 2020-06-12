/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.data.JsonFile;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.tasks.Esquema;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import org.hamcrest.Matchers;
import org.seleniumhq.jetty9.http.HttpStatus;

public class CondicionesClienteSteps {
  private ActorData actorData;

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado(
      "que se obtiene un usuario tipo cliente {string} actualizado {string} lista restrictiva {string}")
  public void queSeObtieneUnUsuarioTipoClienteActualizadoListaRestrictiva(
      String client, String updated, String listRest) {

    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .restrictiveList(Boolean.valueOf(listRest))
            .build();

    actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled(
            "usuario tipo cliente "
                + client
                + " actualizado "
                + updated
                + " y listas restrictivas "
                + listRest)
        .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Dado(
      "que tengo un usuario tipo cliente {string} actualizado {string} canales {string} cuenta cat {string} lista restrictiva {string}")
  public void queTengoUnUsuarioTipoClienteActualizadoCanalesCuentaCatListaRestrictiva(
      String client, String updated, String channels, String cat, String listRest) {

    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .channels(Boolean.valueOf(channels))
            .cat(Boolean.valueOf(cat))
            .restrictiveList(Boolean.valueOf(listRest))
            .build();

    actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled(
            "usuario tipo cliente "
                + client
                + " actualizado "
                + updated
                + " canales "
                + channels
                + " y cuenta cat "
                + cat)
        .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Cuando("consumo el servicio rest de condiciones cliente")
  public void consumoElServicioRestDeCondicionesCliente() {
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

    BodyGenerarOtp bodyCustCond =
        BodyGenerarOtp.builder()
            .documentType(actorData.getDocumentType())
            .documentNumber(actorData.getDocumentNumber())
            .build();

    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathCustomerConditions(), bodyCustCond));
  }

  @Entonces("el obtengo la informacion de las condiciones del cliente")
  public void elObtengoLaInformacionDeLasCondicionesDelCliente() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Esquema.validacion("schemas/example/customer-conditions.json"),
            Ensure.that("status code is 200", response -> response.statusCode(HttpStatus.OK_200)),
            Ensure.that(
                "Se confirma que el usuario es cliente",
                response -> response.body("client", Matchers.is(actorData.isClient()))),
            Ensure.that(
                "Se confirma que el usuario no es lista restrictiva",
                response ->
                    response.body("restrictiveList", Matchers.is(actorData.isRestrictiveList()))),
            Ensure.that(
                "Se confirma que el usuario es actualizado",
                response -> response.body("updated", Matchers.is(actorData.isUpdated()))));

    JsonFile.setProperty("block", false);
  }
}
