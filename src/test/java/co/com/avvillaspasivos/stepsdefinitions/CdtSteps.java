/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.PerformFlowCdt;
import co.com.avvillaspasivos.tasks.ResumenValidationCdt;
import co.com.avvillaspasivos.tasks.uitask.CreateCdtWithNewAccount;
import co.com.avvillaspasivos.tasks.uivalidation.ResumenAssertions;
import co.com.avvillaspasivos.ui.ErrorResumePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CdtSteps {

  @Entonces("se muestra el resumen de la creación del CDT")
  public void seMuestraElResumenDeLaCreaciónDelCDT() {
    theActorInTheSpotlight()
        .attemptsTo(
            Check.whether(the(ErrorResumePage.SUMMARY_CONTAINER), isPresent())
                .otherwise(ResumenValidationCdt.perform()));
  }

  @Cuando("el usuario realiza el flujo con rendimientos {string}")
  public void elUsuarioRealizaElFlujoConRendimientos(String period) {
    theActorInTheSpotlight().attemptsTo(PerformFlowCdt.type(period));
  }

  @Cuando("el usuario realiza el flujo abriendo una cuenta AV Villas")
  public void elUsuarioRealizaElFlujoAbriendoUnaCuentaAVVillas() {
    theActorInTheSpotlight().attemptsTo(CreateCdtWithNewAccount.exec());
  }

  @Entonces(
      "se muestra el numero de cuenta que se abrió en pago de rendimientos y en sección de cuenta abierta")
  public void seMuestraElNumeroDeCuentaQueSeAbrióEnPagoDeRendimientosYEnSecciónDeCuentaAbierta() {
    OnStage.theActorInTheSpotlight().attemptsTo(ResumenAssertions.newAccountSection());
  }
}
