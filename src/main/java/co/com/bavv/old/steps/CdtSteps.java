/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.PerformFlowCdt;
import co.com.bavv.old.tasks.ResumenValidationCdt;
import co.com.bavv.old.tasks.uitask.CreateCdtWithNewAccount;
import co.com.bavv.old.tasks.uivalidation.ResumenAssertions;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CdtSteps {

  @Entonces("se muestra el resumen de la creación del CDT")
  public void seMuestraElResumenDeLaCreaciónDelCDT() {
    theActorInTheSpotlight().attemptsTo(ResumenValidationCdt.perform());
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
