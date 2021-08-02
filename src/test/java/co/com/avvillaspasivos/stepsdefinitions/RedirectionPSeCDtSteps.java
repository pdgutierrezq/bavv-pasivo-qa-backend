/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.DeclaringSelection;
import co.com.avvillaspasivos.tasks.EnrollmentKey;
import co.com.avvillaspasivos.tasks.SignDocuments;
import co.com.avvillaspasivos.tasks.TasksGroup;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.avvillaspasivos.util.Constantes.TAG_CONFIRM;
import static co.com.avvillaspasivos.util.Constantes.UI_URL_PATHS;

public class RedirectionPSeCDtSteps {
  @Cuando("el usuario selecciona fondeó por {string}")
  public void elUsuarioSeleccionaFondeóPor(String fundingOption) {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.fundingSelectBy(fundingOption));
  }

  @Y("obtiene informacion de si esta enrolado")
  public void obtieneInformacionDeSiEstaEnrolado() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(DeclaringSelection.choose(TAG_CONFIRM), SignDocuments.perform());
  }

  @Entonces("se redirecciona al cliente a pantalla de {string}")
  public void seRedireccionaAlClienteAPantallaDe(String screenType) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.thatTheCurrentPage().currentUrl().contains(UI_URL_PATHS.get(screenType)));
  }

  @Y("falla el proceso de enrolamiento")
  public void fallaElProcesoDeEnrolamiento() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            DeclaringSelection.choose(TAG_CONFIRM),
            SignDocuments.perform(),
            EnrollmentKey.perform());
  }
}
