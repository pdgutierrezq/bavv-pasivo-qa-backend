/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.ui.*;
import co.com.avvillaspasivos.util.Constantes;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UiAssertions {

  private UiAssertions() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validateIncomeFormat() {
    return Task.where(
        "{0} valida que presenta formato numero",
        Ensure.that(IdentificationPage.SALARY_INPUT).value().contains("$"),
        Ensure.that(IdentificationPage.SALARY_INPUT).value().contains(".")
    );
  }

  public static Performable validateMinIncome(String msg) {
    return Task.where(
        "{0} valida que solo este presente la card de cuenta Pro",
        Ensure.that(IdentificationPage.ALERT_ERROR).textContent().isEqualToIgnoringCase(msg));
  }

  public static Performable validateAccountSelectionWithCat(String text) {
    return Task.where(
        "{0} valida que solo este presente la card de cuenta Pro",
        Ensure.that(ProductOfferingPage.TITLE_PRODUCT_OFFERING).textContent().contains(text),
        Ensure.that(ProductOfferingPage.FIRST_CARD).textContent().contains("PRO"),
        Ensure.that(ProductOfferingPage.RADIO_SIMPLE).isNotDisplayed());
  }

  public static Performable validateAccountOffering(String text, String account, Target radio) {
    return Task.where(
        "{0} valida el titulo de la oferta para cuenta simple",
        Ensure.that(ProductOfferingPage.TITLE_PRODUCT_OFFERING).textContent().contains(text),
        Ensure.that(ProductOfferingPage.FIRST_CARD).textContent().contains(account),
        Ensure.that(radio.resolveFor(OnStage.theActorInTheSpotlight()).isSelected()).isTrue());
  }

  public static Performable validateInsuranceOffer() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla oferta de seguro",
        WaitUntil.the(InsuranceOfferPage.RADIO_ACEPTA_SEGURO, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.insuranceOfferPath()));
  }

  public static Performable validateProductOfferingCharge() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla oferta de productos",
        WaitUntil.the(ProductOfferingPage.RADIO_PRO, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.productOfferingPath()));
  }

  public static Performable validateAccoutPackageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de selección de paquetes",
        WaitUntil.the(AccountPackagePage.FORM_ACCOUNT_PACKAGE, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.accountPackagePath()));
  }

  public static Performable validateContinueOptionPep() {
    return Task.where(
        "{0} valida opcion continuar pep", Ensure.that(PepPage.CONTINUE_BUTTON).isEnabled());
  }

  public static Performable validateSelectedRadio(Target radio) {
    return Task.where(
        "{0} valida que el la tarjeta de la cuenta este seleccionada",
        Ensure.that(radio.resolveFor(OnStage.theActorInTheSpotlight()).isSelected()).isTrue());
  }

  public static Performable validarPantallaErrorDeProceso() {
    return Task.where(
        "{0} valida la corrección de la pantalla de error de proceso",
        Ensure.that(ErrorPage.TEXT_MENSAJE_PRINCIPAL)
            .text()
            .isEqualToIgnoringCase(TEXTO_ERROR_PROCESO_PRINCIPAL),
        Ensure.that(ErrorPage.TEXT_MENSAJE_SECUNDARIO)
            .text()
            .isEqualToIgnoringCase(TEXTO_ERROR_PROCESO_SECUNDARIO),
        Ensure.that(ErrorPage.BTN_DONDE_ENCONTRARNOS).isEnabled());
  }

  public static Performable validarBotonContinuarLanding() {
    return Task.where(
        "{0} valida boton continuar landing",
        WaitUntil.the(IdentificationPage.CONTINUE_BUTTON, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(Constantes.PATH_FORM_IDENTIFICACION));
  }

  public static Performable validarPantallaPep() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla pep",
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.pepPagePath()));
  }

  public static Performable validarPopUpPep() {
    return Task.where(
        "{0} valida la presencia del pop up de pep", Ensure.that(PepPage.POP_UP_PEP).isDisplayed());
  }

  public static Performable validateContinueButtonFormIdentificationEnabled() {
    return Task.where(
        "{0} valida boton continuar formulario identificacion habilitado",
        Scroll.to(IdentificationPage.CONTINUE_BUTTON),
        Ensure.that(IdentificationPage.CONTINUE_BUTTON).isEnabled());
  }

  public static Performable botonContinuarFormIdentificacionDisabled() {
    return Task.where(
        "{0} valida boton continuar landing deshabilitado",
        Scroll.to(IdentificationPage.CONTINUE_BUTTON),
        Ensure.that(IdentificationPage.CONTINUE_BUTTON).isDisabled());
  }

  public static Performable cantidadMsjObligatoriosFormIdentificacion() {
    return Task.where(
        "{0} valida mensajes de error en formulario identificacion",
        Ensure.that(IdentificationPage.MSJ_CAMPOS_OBLIG).values().hasSize(5));
  }

  public static Performable validarMensajeCelularErrado(String mensaje) {
    return Task.where(
        "{0} valida mensajes de error por celular errado",
        Ensure.that(IdentificationPage.ALERT_ERROR).text().contains(mensaje));
  }

  public static Performable validatePopUpHabeasData() {
    return Task.where(
        "{0} valida presencia de popup habeas data",
        Ensure.that(IdentificationPage.VER_MAS_HABEAS_DATA_POPUP).isDisplayed());
  }

  public static Performable validaFormularioIdentificacionHabilitado() {
    return Task.where(
        "{0} valida que no este presente el popup de habeas data",
        Ensure.that(IdentificationPage.VER_MAS_HABEAS_DATA_POPUP).isNotDisplayed());
  }

  public static Performable validarCantidadLimiteTexto() {
    return Task.where(
        "{0} valida que no se supere el limite de texto en campos de texto",
        Ensure.that(IdentificationPage.PRIMER_NOMBRE_INPUT).value().hasSize(20),
        Ensure.that(IdentificationPage.PRIMER_APELLIDO_INPUT).value().hasSize(20));
  }

  public static Performable validateSalaryLimitForm() {

    return Task.where(
        "{0} valida que no se supere el limite del salario",
        Ensure.that(
                IdentificationPage.SALARY_INPUT
                    .resolveFor(OnStage.theActorInTheSpotlight())
                    .getValue()
                    .replace(" ", "")
                    .replace("$", "")
                    .replace(".", ""))
            .hasSize(SALARY_SIZE));
  }

  public static Performable validarCantidadTextoConfirmacionCel() {
    return Task.where(
        "{0} valida que no exista informacion despues de pegar sobre el campo confirmacion celular",
        Ensure.that(IdentificationPage.PRIMER_NOMBRE_INPUT).value().hasSize(0));
  }
}
