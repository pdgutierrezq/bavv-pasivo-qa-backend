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
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import io.cucumber.datatable.DataTable;

import static co.com.avvillaspasivos.tasks.SmallTasks.leaveEmptyCityField;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SendingCardSteps {

  @Y(
      "el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP")
  public void
      dadoQueElClienteEstáEnLaPantallaDeConfirmaciónDeDirecciónDeEnvíoDeLaTarjetaDébitoYVieneDeOTP() {
    theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToSendCard());
  }

  @Cuando("se cargue la pantalla")
  public void seCargueLaPantalla() {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validateDeliveryAddressCharge());
  }

  @Entonces("el sistema debe traer la dirección y ciudad de residencia que tiene en memoria")
  public void elSistemaDebeTraerLaDirecciónYCiudadDeResidenciaQueTieneEnMemoria() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateAddressTextBoxPrecharged());
  }

  @Cuando("el cliente {string} la direccion y continue")
  public void elClienteLaDireccionYContinue(String option) {
    theActorInTheSpotlight().attemptsTo(EditAddress.toSendCard(option));
  }

  @Entonces("saldrá el POP-UP de confirmación con la información ingresada")
  public void saldráElPOPUPDeConfirmaciónConLaInformaciónIngresada() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validatePopUpDirection());
  }

  @Cuando("{string} la nueva direccion en el POP-UP")
  public void laNuevaDireccionEnElPOPUP(String option) {
    theActorInTheSpotlight().attemptsTo(PopUpAddressOptions.choose(option));
  }

  @Entonces("pasará a pregunta de no declarante")
  public void pasaráAPreguntaDeNoDeclarante() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateDeclaringPageCharge());
  }

  @Y("el cliente recuerda la direccion que se precarga de crm")
  public void elClienteRecuerdaLaDireccionQueSePrecargaDeCrm() {
    theActorInTheSpotlight().attemptsTo(RememberAddress.fromSendCard());
  }

  @Entonces(
      "volverá a pantalla de Dirección de envío de tarjeta Débito con la información pre cargada en memoria que venia de CRM")
  public void
      volveráAPantallaDeDirecciónDeEnvíoDeTarjetaDébitoConLaInformaciónPreCargadaEnMemoriaQueVeniaDeCRM() {
    theActorInTheSpotlight().attemptsTo(BdUser.toBlock(false), UiAssertions.validateCrmAddress());
  }

  @Cuando("ingrese textos en el campo de dirección como")
  public void ingreseTextosEnElCampoDeDirecciónComo(DataTable table) {
    theActorInTheSpotlight().remember(String.valueOf(SessionVariables.WORD_LIST), table.asList());
  }

  @Entonces("Se validará que se presenta el mensaje {string} al ingresar palabra invalidas")
  public void seValidaráQueSePresentaElMensajeAlIngresarPalabraInvalidas(String errorText) {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validateInvalidWordsOnAddres(errorText));
  }

  @Cuando("ingrese un numero en la primera posición y cambié de campo")
  public void ingreseUnNumeroEnLaPrimeraPosiciónYCambiéDeCampo() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.writeAnyNumberOnAddress());
  }

  @Entonces("le aparecerá un mensaje informando que {string}")
  public void leApareceráUnMensajeInformandoQue(String errorText) {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validateAlert(errorText));
  }

  @Cuando("ingrese un @ en cualquier posición  y cambié de campo")
  public void ingreseUnEnCualquierPosiciónYCambiéDeCampo() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.writeAddressWithAtSymbol());
  }

  @Cuando("ingrese un valor inferior a {int} caracteres")
  public void ingreseUnValorInferiorACaracteres(int limitChars) {
    theActorInTheSpotlight().attemptsTo(SmallTasks.writeTextWithSize(limitChars));
  }

  @Cuando("ingrese a digitar el campo")
  public void ingreseADigitarElCampo() {
    theActorInTheSpotlight().attemptsTo(leaveEmptyCityField());
  }

  @Entonces(
      "se desplegará el listado de las ciudades o municipios de Colombia que tiene cobertura de Domina.")
  public void seDesplegaráElListadoDeLasCiudadesOMunicipiosDeColombiaQueTieneCoberturaDeDomina() {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validateCityList());
  }

  @Y("será un bloqueante para la activación de la opción continuar")
  public void seráUnBloqueanteParaLaActivaciónDeLaOpciónContinuar() {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validateContinueAddressDisabled());
  }

  @Cuando("ingrese alguna ciudad que no este en la lista desplegable")
  public void ingreseAlgunaCiudadQueNoEsteEnLaListaDesplegable() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.insertInvalidCity());
  }

  @Cuando("deje el campo de dirección o de ciudad vacío y cambie de campo")
  public void dejeElCampoDeDirecciónODeCiudadVacíoYCambieDeCampo() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.leaveEmptyFields());
  }

  @Cuando("cambie la ciudad y sea una Ciudad valida")
  public void cambieLaCiudadYSeaUnaCiudadValida() {
    theActorInTheSpotlight().attemptsTo(City.autoComplete());
  }

  @Entonces("El campo de dirección y check de transporte masivo deberá quedar vació")
  public void elCampoDeDirecciónYCheckDeTransporteMasivoDeberáQuedarVació() {
      theActorInTheSpotlight()
          .attemptsTo(
              UiAssertions.validateAutocompleteCityAddress()
          );
  }
}
