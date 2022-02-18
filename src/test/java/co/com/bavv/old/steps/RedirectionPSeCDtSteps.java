/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.DeclaringSelection;
import co.com.bavv.old.tasks.EnrollmentKey;
import co.com.bavv.old.tasks.SignDocuments;
import co.com.bavv.old.tasks.SmallTasks;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class RedirectionPSeCDtSteps {
  @Cuando("el usuario selecciona fondeó por {string}")
  public void elUsuarioSeleccionaFondeóPor(String fundingOption) {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.fundingSelectBy(fundingOption));
  }

  @Y("obtiene informacion de si esta enrolado")
  public void obtieneInformacionDeSiEstaEnrolado() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            SmallTasks.passCdtFeatures(), DeclaringSelection.choose(Constantes.TAG_CONFIRM), SignDocuments.perform());
  }

  @Entonces("se redirecciona al cliente a pantalla de {string}")
  public void seRedireccionaAlClienteAPantallaDe(String screenType) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.thatTheCurrentPage().currentUrl().contains(Constantes.UI_URL_PATHS.get(screenType)));
  }

  @Y("falla el proceso de enrolamiento")
  public void fallaElProcesoDeEnrolamiento() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            SmallTasks.passCdtFeatures(),
            DeclaringSelection.choose(Constantes.TAG_CONFIRM),
            SignDocuments.perform(),
            EnrollmentKey.perform());
  }
}
