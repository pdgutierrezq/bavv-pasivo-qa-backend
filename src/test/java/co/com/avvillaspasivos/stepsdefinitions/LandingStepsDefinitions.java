package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.AsercionesUi;
import co.com.avvillaspasivos.tasks.BeneficiosLanding;
import co.com.avvillaspasivos.tasks.NavegarA;
import co.com.avvillaspasivos.tasks.VerMas;
import co.com.avvillaspasivos.util.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class LandingStepsDefinitions {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado(
      "que el {string} ingreso al landing y vio landing  con esta informacion: un mensaje que motive a aperturar la cuenta  Descripcion o beneficios de las cuentas")
  public void
      queElIngresoAlLandingYVioLandingConEstaInformacionUnMensajeQueMotiveAAperturarLaCuentaDescripcionOBeneficiosDeLasCuentas(
          String featureActor) {
    OnStage.theActorCalled(featureActor).attemptsTo(NavegarA.homePage());
  }

  @Dado(
      "que el usuario ingreso al landing y vió landing  con esta informacion: un mensaje que motive a aperturar la cuenta  Descripcion o beneficios de las cuentas")
  public void
      queElUsuarioIngresoAlLandingYVióLandingConEstaInformacionUnMensajeQueMotiveAAperturarLaCuentaDescripcionOBeneficiosDeLasCuentas() {}

  @Cuando("de click en comenzar")
  public void deClickEnComenzar() {
    OnStage.theActorInTheSpotlight().attemptsTo(NavegarA.comenzarSolicitud());
  }

  @Cuando("de click en ver mas")
  public void deClickEnVerMas() {
    OnStage.theActorInTheSpotlight().attemptsTo(BeneficiosLanding.verMas());
  }

  @Entonces("se desplegará un cuadro con información de beneficios.")
  public void seDesplegaráUnCuadroConInformaciónDeBeneficios() {
    OnStage.theActorInTheSpotlight().attemptsTo(VerMas.validate(Constantes.TEXT_MODAL_VER_MAS));
  }

  @Entonces("se desplegará un cuadro para su identificación")
  public void seDesplegaráUnCuadroParaSuIdentificación() {
    OnStage.theActorInTheSpotlight().attemptsTo(AsercionesUi.validarBotonContinuarLanding());
  }
}
