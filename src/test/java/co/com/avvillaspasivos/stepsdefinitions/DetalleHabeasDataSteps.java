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
import co.com.avvillaspasivos.tasks.NavegarA;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class DetalleHabeasDataSteps {

    @Dado("que el {string} quiere saber que es la autorizacion de habeas data")
    public void queElQuiereSaberQueEsLaAutorizacionDeHabeasData(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(NavegarA.homePage(), NavegarA.comenzarSolicitud());
    }

    @Cuando("de click en ver mas habeas data")
    public void deClickEnVerMasHabeasData() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.verMasHabeasData());
    }

    @Entonces(
        "se le desplegara un Pop-Up con la informacion de lo que es la autorizacion del habeas data.")
    public void seLeDesplegaraUnPopUpConLaInformacionDeLoQueEsLaAutorizacionDelHabeasData() {
        OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validatePopUpHabeasData());
    }

    @Cuando("Cuando de click en entendido")
    public void cuandoDeClickEnEntendido() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.entendidoHabeasData());
    }

    @Entonces("Regresara a la pantalla de identificacion cliente")
    public void regresaraALaPantallaDeIdentificacionCliente() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(AsercionesUi.validaFormularioIdentificacionHabilitado());
    }

    @Dado("que el {string} esta en el POPUP de lo que es la autorizacion de habeas data")
    public void queElEstaEnElPOPUPDeLoQueEsLaAutorizacionDeHabeasData(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(NavegarA.homePage(), NavegarA.comenzarSolicitud(), NavegarA.verMasHabeasData());
    }

    @Cuando("Cuando de click en cerrar")
    public void cuandoDeClickEnCerrar() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.cerrarHabeasData());
    }
}
