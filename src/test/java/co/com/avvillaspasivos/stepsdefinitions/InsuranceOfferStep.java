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

public class InsuranceOfferStep {
  @Y("que el cliente se encuentra en pantalla donde se muestra ofrecimiento del seguro")
  public void queElClienteSeEncuentraEnPantallaDondeSeMuestraOfrecimientoDelSeguro() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToInsuranceOffering());
  }

  @Entonces("se activara la opcion continuar")
  public void seActivaraLaOpcionContinuar() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateContinueOptionInsurance());
  }

  @Cuando("el usuario {string} el seguro")
  public void elUsuarioElSeguro(String afirmation) {
    OnStage.theActorInTheSpotlight().attemptsTo(InsuranceSelection.choose(afirmation, false));
  }

  @Cuando("ingresa en la opcion ver mas")
  public void ingresaEnLaOpcionVerMas() {
    OnStage.theActorInTheSpotlight().attemptsTo(SmallTasks.seeMoreInsurance());
  }

  @Cuando("ingrese en la opcion cerrar o el entendido")
  public void ingresaEnLaOpcionCerrar() {
    OnStage.theActorInTheSpotlight().attemptsTo(SmallTasks.understoodPopupButton());
  }

  @Cuando("{string} el seguro y continua")
  public void elSeguroyContinua(String afirmation) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(InsuranceSelection.choose(afirmation, true), Waits.loader());
  }

  @Entonces("se despliega un POP UP con la descripción del seguir")
  public void seDespliegaUnPOPUPConLaDescripciónDelSeguir() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateVisibilityPopUpInsurance(true));
  }

  @Entonces("se cierra el POP-UP quedando el cliente en la pantalla de ofrecimiento de seguro")
  public void seCierraElPopUpQuedandoEnPantallaOfrecimientoSeguro() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateVisibilityPopUpInsurance(false));
  }

  @Entonces("pasa a pantalla de OTP")
  public void pasaAlaPantallaOtp() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateOtpPageCharge());
  }
}
