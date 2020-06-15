/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ErrorPage;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import co.com.avvillaspasivos.util.Constantes;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.avvillaspasivos.util.Constantes.TEXTO_ERROR_PROCESO_PRINCIPAL;
import static co.com.avvillaspasivos.util.Constantes.TEXTO_ERROR_PROCESO_SECUNDARIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AsercionesUi {

  private AsercionesUi() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validarPantallaErrorDeProceso() {
    return Task.where(
        "{0} valida la corrección de la pantalla de error de proceso",
        Ensure.that(ErrorPage.TEXT_MENSAJE_PRINCIPAL).text().contains(TEXTO_ERROR_PROCESO_PRINCIPAL),
        Ensure.that(ErrorPage.TEXT_MENSAJE_SECUNDARIO).text().contains(TEXTO_ERROR_PROCESO_SECUNDARIO),
        Ensure.that(ErrorPage.BTN_DONDE_ENCONTRARNOS).isEnabled());
  }
  public static Performable validarBotonContinuarLanding() {
    return Task.where(
        "{0} valida boton continuar landing",
        WaitUntil.the(IdentificacionPage.CONTINUAR_BUTTON, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(Constantes.PATH_FORM_IDENTIFICACION));
  }

  public static Performable botonContinuarFormIdentificacionEnabled() {
    return Task.where(
        "{0} valida boton continuar landing habilitado",
        Scroll.to(IdentificacionPage.CONTINUAR_BUTTON),
        Ensure.that(IdentificacionPage.CONTINUAR_BUTTON).isEnabled());
  }

  public static Performable botonContinuarFormIdentificacionDisabled() {
    return Task.where(
        "{0} valida boton continuar landing deshabilitado",
        Scroll.to(IdentificacionPage.CONTINUAR_BUTTON),
        Ensure.that(IdentificacionPage.CONTINUAR_BUTTON).isDisabled());
  }

  public static Performable cantidadMsjObligatoriosFormIdentificacion() {
    return Task.where(
        "{0} valida mensajes de error en formulario identificacion",
        Ensure.that(IdentificacionPage.MSJ_CAMPOS_OBLIG).values().hasSize(5));
  }

  public static Performable validarMensajeCelularErrado(String mensaje) {
    return Task.where(
        "{0} valida mensajes de error por celular errado",
        Ensure.that(IdentificacionPage.ALERT_ERROR).text().contains(mensaje));
  }

  public static Performable validatePopUpHabeasData() {
    return Task.where(
        "{0} valida presencia de popup habeas data",
        Ensure.that(IdentificacionPage.VER_MAS_HABEAS_DATA_POPUP).isDisplayed());
  }

  public static Performable validaFormularioIdentificacionHabilitado() {
    return Task.where(
        "{0} valida que no este presente el popup de habeas data",
        Ensure.that(IdentificacionPage.VER_MAS_HABEAS_DATA_POPUP).isNotDisplayed());
  }

  public static Performable validarCantidadLimiteTexto() {
    return Task.where(
        "{0} valida que no se supere el limite de texto en campos de texto",
        Ensure.that(IdentificacionPage.PRIMER_NOMBRE_INPUT).value().hasSize(20),
        Ensure.that(IdentificacionPage.PRIMER_APELLIDO_INPUT).value().hasSize(20));
  }

  public static Performable validarCantidadTextoConfirmacionCel() {
    return Task.where(
        "{0} valida que no exista informacion despues de pegar sobre el campo confirmacion celular",
        Ensure.that(IdentificacionPage.PRIMER_NOMBRE_INPUT).value().hasSize(0));
  }
}
