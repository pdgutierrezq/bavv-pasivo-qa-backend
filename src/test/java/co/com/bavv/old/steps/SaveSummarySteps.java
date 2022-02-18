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
import co.com.bavv.old.tasks.GetToken;
import co.com.bavv.old.tasks.apitask.SaveSummaryTransaction;
import co.com.bavv.old.tasks.apivalidation.SaveSummaryResponse;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SaveSummarySteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que el {string} se autentica en el sistema")
  public void queElSeAutenticaEnElSistema(String userType) {
    theActorCalled(Constantes.SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
    theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
  }

  @Cuando("el {string} actualiza la informaicon de resumen de forma exitosa")
  public void elActualizaLaInformaiconDeResumenDeFormaExitosa(String userType) {
    OnStage.theActorCalled(userType).attemptsTo(SaveSummaryTransaction.post());
  }

  @Entonces("se confirmará que se actualizó la información")
  public void seConfirmaráQueSeActualizóLaInformación() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(SaveSummaryResponse.validate());
  }
}
