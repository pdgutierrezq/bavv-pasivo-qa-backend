/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.GetFlowDataActor;
import co.com.bavv.old.tasks.PerformFlow;
import co.com.bavv.old.tasks.ResumenValidation;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class e2eStepsDefinitions {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Entonces("se muestra el resumen de la creación de la cuenta")
  public void seMuestraElResumenDeLaCreacionDeLaCuenta() {
    theActorInTheSpotlight().attemptsTo(ResumenValidation.perform());
  }

  @Dado("que se obtiene un usuario tipo {string}")
  public void queSeObtieneUnUsuarioTipo(String userType) {
    theActorCalled(Constantes.SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
  }

  @Cuando("el usuario realiza el flujo con {string} y {string} el seguro")
  public void elUsuarioRealizaElFlujoConYElSeguro(String accountType, String insurance) {
    theActorInTheSpotlight().attemptsTo(PerformFlow.type(accountType, insurance));
  }
}
