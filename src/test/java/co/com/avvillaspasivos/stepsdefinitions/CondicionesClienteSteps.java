/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.JsonFile;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.tasks.Esquema;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
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

  @Cuando("consumo el servicio rest de condiciones cliente")
  public void consumoElServicioRestDeCondicionesCliente() {
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    actorData=OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

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
    JsonFile.setProperty("block", false);

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
  }
}
