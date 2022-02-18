/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.BodyWs;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.tasks.ApiValidations;
import co.com.bavv.old.tasks.BdUser;
import co.com.bavv.old.tasks.CallPost;
import co.com.bavv.old.tasks.Schema;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CustomerAccountsSteps {

  @Dado("que se obtiene un usuario tipo cat {string}")
  public void queSeObtieneUnUsuarioTipoCat(String cat) {
    ActorActions.configure(cat);
  }

  @Cuando("consumo el servicio rest de cuentas cliente")
  public void consumoElServicioRestDeCuentasCliente() {
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    ActorData actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

    BodyWs bodyCustAccounts =
        BodyWs.builder()
            .documentType(actorData.getDocumentType())
            .documentNumber(actorData.getDocumentNumber())
            .build();

    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathCustomerAccounts(), bodyCustAccounts));
  }

  @Entonces("se validara que la respuesta coincide con las cuentas del cliente")
  public void seValidaraQueLaRespuestaCoincideConLasCuentasCelCliente() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            BdUser.toBlock(false),
            Schema.validation(ServicePaths.pathCustAccountSchema()),
            ApiValidations.customerAccounts());
  }
}
