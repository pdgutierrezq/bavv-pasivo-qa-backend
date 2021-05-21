/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.ApiValidations;
import co.com.avvillaspasivos.tasks.GetFlowDataActor;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.tasks.apitask.GetCustomerConditions;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.avvillaspasivos.paths.ServicePaths.pathCustConditionsSchema;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CustomerConditionsSteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que se obtiene un usuario para condiciones cliente de tipo {string}")
  public void queSeObtieneUnUsuarioParaCondicionesClienteDeTipo(String userType) {
    theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
  }

  @Cuando("consumo el servicio rest de condiciones cliente")
  public void consumoElServicioRestDeCondicionesCliente() {
    OnStage.theActorInTheSpotlight().attemptsTo(GetCustomerConditions.post());
  }

  @Entonces("el obtengo la informacion de las condiciones del cliente")
  public void elObtengoLaInformacionDeLasCondicionesDelCliente() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Schema.validation(pathCustConditionsSchema()), ApiValidations.customerConditions());
  }
}
