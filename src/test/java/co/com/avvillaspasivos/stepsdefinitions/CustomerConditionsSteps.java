/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.BodyWs;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.ApiValidations;
import co.com.avvillaspasivos.tasks.BdUser;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.avvillaspasivos.paths.ServicePaths.pathCustConditionsSchema;
import static co.com.avvillaspasivos.paths.ServicePaths.pathCustomerConditions;

public class CustomerConditionsSteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Cuando("consumo el servicio rest de condiciones cliente")
  public void consumoElServicioRestDeCondicionesCliente() {
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    ActorData actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

    BodyWs bodyCustCond =
        BodyWs.builder()
            .documentType(actorData.getDocumentType())
            .documentNumber(actorData.getDocumentNumber())
            .build();

    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(pathCustomerConditions(), bodyCustCond));
  }

  @Entonces("el obtengo la informacion de las condiciones del cliente")
  public void elObtengoLaInformacionDeLasCondicionesDelCliente() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            BdUser.toBlock(false),
            Schema.validation(pathCustConditionsSchema()),
            ApiValidations.customerConditions());
  }
}
