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

public class SendingCardSteps {

  @Y(
      "el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP")
  public void
      dadoQueElClienteEstáEnLaPantallaDeConfirmaciónDeDirecciónDeEnvíoDeLaTarjetaDébitoYVieneDeOTP() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToSendCard());
  }

  @Cuando("se cargue la pantalla")
  public void seCargueLaPantalla() {
    OnStage.theActorInTheSpotlight().attemptsTo(UiAssertions.validateDeliveryAddressCharge());
  }

  @Entonces("el sistema debe traer la dirección y ciudad de residencia que tiene en memoria")
  public void elSistemaDebeTraerLaDirecciónYCiudadDeResidenciaQueTieneEnMemoria() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateAddressTextBoxPrecharged());
  }

  @Cuando("el cliente {string} la direccion y continue")
  public void elClienteLaDireccionYContinue(String option) {
    OnStage.theActorInTheSpotlight().attemptsTo(EditAddress.toSendCard(option));
  }

  @Entonces("saldrá el POP-UP de confirmación con la información ingresada")
  public void saldráElPOPUPDeConfirmaciónConLaInformaciónIngresada() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validatePopUpDirection());
  }

  @Cuando("{string} la nueva direccion en el POP-UP")
  public void laNuevaDireccionEnElPOPUP(String option) {
    OnStage.theActorInTheSpotlight().attemptsTo(PopUpAddressOptions.choose(option));
  }

  @Entonces("pasará a pregunta de no declarante")
  public void pasaráAPreguntaDeNoDeclarante() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateDeclaringPageCharge());
  }

  @Y("el cliente recuerda la direccion que se precarga de crm")
  public void elClienteRecuerdaLaDireccionQueSePrecargaDeCrm() {
    OnStage.theActorInTheSpotlight().attemptsTo(RememberAddress.fromSendCard());
  }

  @Entonces(
      "volverá a pantalla de Dirección de envío de tarjeta Débito con la información pre cargada en memoria que venia de CRM")
  public void
      volveráAPantallaDeDirecciónDeEnvíoDeTarjetaDébitoConLaInformaciónPreCargadaEnMemoriaQueVeniaDeCRM() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateCrmAddress());
  }
}
