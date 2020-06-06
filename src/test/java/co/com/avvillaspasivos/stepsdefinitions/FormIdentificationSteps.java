/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.AsercionesUi;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class FormIdentificationSteps {


  @Dado(
      "que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos")
  public void
      queElUsuarioEstaInteresadoEnAdquirirElProductoYEnPantallaSeMuestraElFormularioDeDatos() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial());
  }
    @Dado("que el {string} esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos")
    public void queElEstaInteresadoEnAdquirirElProductoYEnPantallaSeMuestraElFormularioDeDatos(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(
                NavegarA.homePage(),
                NavegarA.comenzarSolicitud(),
                FormIdentificacion.validarCargaInicial());
     }

  @Cuando("ingresa los datos correctamente")
  public void ingresaLosDatosCorrectamente() {
    OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.diligenciar());
  }

  @Cuando("ingresa los datos incompletos")
  public void ingresaLosDatosIncompletos() {
    OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.noDiligenciar());
  }

  @Entonces("se activara el boton de continuar")
  public void seActivaraElBotonDeContinuar() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(AsercionesUi.botonContinuarFormIdentificacionEnabled());
  }

  @Entonces("no se activara el boton de continuar y muestra mensaje de error")
  public void noSeActivaraElBotonDeContinuarYMuestraMensajeDeError() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            AsercionesUi.botonContinuarFormIdentificacionDisabled(),
            AsercionesUi.cantidadMsjObligatoriosFormIdentificacion());
  }

  @Dado("que el {string} esta en la pantalla del formulario de identificacion de usuario")
  public void queElEstaEnLaPantallaDelFormularioDeIdentificacionDeUsuario(String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial());
  }

  @Cuando("ingresa celular con cuarto numero igual a 1 o 0")
  public void ingresaCelularConCuartoNumeroIgualAO() {
    OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.digitarCelularErrado());
  }

  @Entonces("genera mensaje {string}")
  public void generaMensaje(String mensaje) {
    OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarMensajeCelularErrado(mensaje));
  }

  @Dado("que los campos donde digito mi informacion son tipo texto")
  public void queLosCamposDondeDigitoMiInformacionSonTipoTexto() {
    OnStage.theActorCalled("Usuario")
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial());
  }

  @Cuando("ingrese mas de 20 caracteres")
  public void ingreseMasDeCaracteres() {
    OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.ingresarTextoFueraDelLimite());
  }

  @Entonces("no me permite ingresar mas datos")
  public void noMePermiteIngresarMasDatos() {
    OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarCantidadLimiteTexto());
  }

  @Dado("que el {string} esta digitando informacion en el campo confirmacion de telefono")
  public void queElEstaDigitandoInformacionEnElCampoConfirmacionDeTelefono(String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial());
  }

  @Cuando("intente pegar la informacion \\(control V)")
  public void intentePegarLaInformacionControlV() {
    OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.copiarPegarTelefono());
  }

  @Entonces("no me permitira pegar los datos")
  public void noMePermitiraPegarLosDatos() {
    OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarCantidadTextoConfirmacionCel());
  }


}
