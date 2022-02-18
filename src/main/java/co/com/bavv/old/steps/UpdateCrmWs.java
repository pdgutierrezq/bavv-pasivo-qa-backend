/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.CrmInfo;
import co.com.bavv.old.tasks.apitask.CreatePasiveProduct;
import co.com.bavv.old.tasks.apitask.GetTokenBy;
import co.com.bavv.old.tasks.apitask.GetUpdateCrmClient;
import co.com.bavv.old.tasks.apitask.UpdateCrm;
import co.com.bavv.old.tasks.apivalidation.ValidateUpdatedData;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UpdateCrmWs {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que el {string} se autenticó, radicó pasivo y consultó crm")
  public void queElSeAutenticóRadicóPasivoYConsultóCrm(String userType) {
    theActorCalled(Constantes.SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetUpdateCrmClient.perform());
    theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(
        GetTokenBy.userIdentity(Constantes.DEV_ENV));
    theActorCalled(Constantes.CONSULTAR_CRM).attemptsTo(CrmInfo.post());
    theActorCalled("RADICAR_PASIVO").attemptsTo(CreatePasiveProduct.post());
  }

  @Cuando("el usuario actualiza la información en crm")
  public void elUsuarioActualizaLaInformaciónEnCrm() {
    theActorCalled(Constantes.ACTUALIZAR_CRM).attemptsTo(UpdateCrm.post());
  }

  @Entonces("se validará que la información se actualizó")
  public void seValidaráQueLaInformaciónSeActualizó() {
    OnStage.theActorInTheSpotlight().attemptsTo(ValidateUpdatedData.perform());
  }
}
