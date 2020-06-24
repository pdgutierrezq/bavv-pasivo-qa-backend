/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class ValidacionPepSteps {
  @Y("el usuario esta en la pantalla de PEP")
  public void elUsuarioEstaEnLaPantallaDePEP() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            GoTo.homePage(),
            GoTo.startOnLanding(),
            FormIdentification.validatePageLoad(),
            FormIdentification.fillAndContinue(),
            Waits.loader());
  }

  @Cuando("selecciona que {string} es PEP")
  public void seleccionaQueEsPEP(String confirmation) {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              PepSelection.option(confirmation)
              );
  }

  @Entonces("la opcion continuar se activará.")
  public void laOpcionContinuarSeActivará() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              UiAssertions.validateContinueOptionPep()
          );
  }

  @Cuando("ingrese en la opcion continuar")
  public void ingreseEnLaOpcionContinuar() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
                GoTo.pepContinue()
          );
  }

  @Entonces("el usuario visualizara la pantalla de ofrecimiento de cuenta")
  public void elUsuarioVisualizaraLaPantallaDeOfrecimientoDeCuenta() {

      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              BdUser.toBlock(false),
              UiAssertions.validateProductOfferingCharge()
          );

  }

  @Entonces(
      "el usuario no podrá continuar con el proceso dado que es un PEP mostrándole la pantalla de error")
  public void elUsuarioNoPodráContinuarConElProcesoDadoQueEsUnPEPMostrándoleLaPantallaDeError() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              BdUser.toBlock(false),
              UiAssertions.validarPantallaErrorDeProceso()
          );
  }
}
