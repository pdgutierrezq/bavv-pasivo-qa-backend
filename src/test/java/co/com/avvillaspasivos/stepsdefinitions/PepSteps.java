/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.JsonFile;
import co.com.avvillaspasivos.tasks.AsercionesUi;
import co.com.avvillaspasivos.tasks.Esperas;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import co.com.avvillaspasivos.ui.PepPage;
import co.com.avvillaspasivos.util.ActorActions;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

public class PepSteps {

  @Cuando("el cliente superó el recaptcha.")
  public void elClienteSuperóElRecaptcha() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial(),
            FormIdentificacion.diligenciarContinuar(),
            Esperas.loader());
  }

  @Entonces("se muestra la pantalla PEP.")
  public void seMuestraLaPantallaPEP() {
      JsonFile.setProperty("block", false);
      OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarPantallaPep());
  }

  @Dado(
      "que el cliente {string} actualizado {string} lista restrictiva {string} esta en pantalla PEP")
  public void queElClienteActualizadoListaRestrictivaEstaEnPantallaPEP(
      String client, String updated, String listRest) {
    ActorActions.configure(client, updated, listRest);

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial(),
            FormIdentificacion.diligenciarContinuar(),
            Esperas.loader());
  }

  @Cuando("el cliente ingresa en el tooltip")
  public void elClienteIngresaEnElTooltip() {
    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(PepPage.VER_MAS_PEP));
  }

  @Entonces("se le muestra la información disponible de lo que es un PEP mediante POP-UP.")
  public void seLeMuestraLaInformaciónDisponibleDeLoQueEsUnPEPMediantePOPUP() {
      JsonFile.setProperty("block", false);

      OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarPantallaPep());
  }
}
