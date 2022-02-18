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
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.UiAssertions;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class InsuranceOfferStep {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que el usuario en la aplicacion {string}")
  public void queElUsuarioEnLaAplicacion(String userType) {
    theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
  }

  @Cuando("que el usuario esta en pantalla de 4 x mil, {string} tiene seguro y continua")
  public void queElUsuarioEstaEnPantallaDe4XMilTieneSeguroYContinua(String insurance) {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateLaterRequiredGmfCda());
  }

  @Entonces("llegará a la pagina de {string}")
  public void llegaráALaPaginaDe(String page) {
    OnStage.theActorInTheSpotlight().attemptsTo(UiAssertions.validatePageLoad(page));
  }
}
