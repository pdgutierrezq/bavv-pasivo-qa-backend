package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.AsercionesUi;
import co.com.avvillaspasivos.tasks.NavegarA;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class DetalleHabeasDataSteps {

  @Dado("que el {string} quiere saber que es la autorización de habeas data")
  public void queElQuiereSaberQueEsLaAutorizaciónDeHabeasData(String actor) {
    OnStage.theActorCalled(actor).attemptsTo(NavegarA.homePage(), NavegarA.comenzarSolicitud());
  }

  @Cuando("de click en ver mas habeas data")
  public void deClickEnVerMasHabeasData() {
    OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.verMasHabeasData());
  }

  @Entonces(
      "se le desplegará un Pop-Up con la información de lo que es la autorización del habeas data.")
  public void seLeDesplegaráUnPopUpConLaInformaciónDeLoQueEsLaAutorizaciónDelHabeasData() {
    OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validatePopUpHabeasData());
  }

  @Cuando("Cuando de click en entendido")
  public void cuandoDeClickEnEntendido() {
    OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.entendidoHabeasData());
  }

  @Entonces("Regresará a la pantalla de identificación cliente")
  public void regresaráALaPantallaDeIdentificaciónCliente() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(AsercionesUi.validaFormularioIdentificacionHabilitado());
  }

  @Dado("que el {string} esta en el POPUP de lo que es la autorización de habeas data")
  public void queElEstaEnElPOPUPDeLoQueEsLaAutorizaciónDeHabeasData(String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(NavegarA.homePage(), NavegarA.comenzarSolicitud(), NavegarA.verMasHabeasData());
  }

  @Cuando("Cuando de click en cerrar")
  public void cuandoDeClickEnCerrar() {
    OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.cerrarHabeasData());
  }
}
