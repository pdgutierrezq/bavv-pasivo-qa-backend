/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.ui.ActividadEconomicaPage;
import co.com.avvillaspasivos.ui.DatosContactoPage;
import co.com.avvillaspasivos.ui.PepPage;
import co.com.avvillaspasivos.ui.ResumenPage;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Keys;

public class e2eStepsDefinitions {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado(
      "el usuario con condiciones cliente {string} actualizado {string} canales {string} y cuenta cat {string}")
  public void elUsuarioConCondicionesClienteActualizadoCanalesYCuentaCat(
      String client, String updated, String channels, String cat) {

    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .channels(Boolean.valueOf(channels))
            .cat(Boolean.valueOf(cat))
            .restrictiveList(false)
            .build();
    ActorData actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled(
            "usuario tipo cliente "
                + client
                + " actualizado "
                + updated
                + " canales "
                + channels
                + " cat "
                + cat
                + " y listas restrictivas "
                + false)
        .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Cuando("el usuario diligencia el formulario de identificacion de usuario")
  public void elUsuarioDiligenciaElFormularioDeIdentificacionDeUsuario() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(FormIdentification.fillAndContinue(), Waits.loader());
  }

  @Y("selecciona el producto {string}")
  public void seleccionaElProducto(String accountType) {
    OnStage.theActorInTheSpotlight().attemptsTo(AccountSelection.type(accountType));
  }

  @Y("{string} el seguro")
  public void elSeguro(String afirmation) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(InsuranceSelection.choose(afirmation, true), Waits.loader());

    OnStage.theActorInTheSpotlight().remember(SessionVariables.INSURANCE.toString(), afirmation);
  }

  @Y("se autentica mediante otp")
  public void seAutenticaMedianteOtp() {
    OnStage.theActorInTheSpotlight().attemptsTo(Autentication.byOtp());
  }

  @Y("{string} la direccion de envio")
  public void laDireccionDeEnvio(String option) {
    OnStage.theActorInTheSpotlight().attemptsTo(EditAddress.toSendCard(option));
  }

  @Y("{string} que es declarante")
  public void queEsDeclarante(String option) {
    OnStage.theActorInTheSpotlight().attemptsTo(DeclaringSelection.choose(option));

    //    JsonFile.setProperty("declarante", true);
  }

  @Y("realiza la firma electronica de documentos")
  public void realizaLaFirmaElectronicaDeDocumentos() {
    OnStage.theActorInTheSpotlight().attemptsTo(SignDocuments.perform());
  }

  @Entonces("se muestra el resumen de la creacion de la cuenta")
  public void seMuestraElResumenDeLaCreacionDeLaCuenta() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), Click.on(ResumenPage.GO_NOW_BUTTON));
  }

  @Y("Selecciono que {string} es PEP")
  public void seleccionoQueEsPEP(String opcion) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Click.on(PepPage.RADIO_NO_PEP), Click.on(PepPage.CONTINUE_BUTTON));
  }

  @Y("{string} el beneficio de excencion de gmf")
  public void elBeneficioDeExcencionDeGmf(String option) {
    OnStage.theActorInTheSpotlight().attemptsTo(RequiredGmf.selection(option));
  }

  @Y("selecciona actividad economica")
  public void seleccionaActividadEconomica() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Click.on(ActividadEconomicaPage.RADIO_HOGAR),
            Click.on(ActividadEconomicaPage.BOTON_CONTINUAR)

            );
  }

  @Y("diligenciar datos de contacto")
  public void diligenciarDatosDeContacto() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Enter.theValue("correo@correo.com").into(DatosContactoPage.TEXTBOX_CORREO),
            Enter.theValue("correo@correo.com").into(DatosContactoPage.TEXTBOX_COPIA_CORREO),
            Enter.theValue("6887788").into(DatosContactoPage.TEXTBOX_TELEFONO),
            Enter.theValue("cra 1 223211").into(DatosContactoPage.TEXTBOX_DIRECCION),
            Enter.theValue("tulua").into(DatosContactoPage.TEXTBOX_CIUDAD).thenHit(Keys.TAB),
            Click.on(DatosContactoPage.BOTON_CONTINUAR));
  }

  @Dado("que se obtiene un usuario tipo {string}")
  public void queSeObtieneUnUsuarioTipo(String userType) {
    OnStage.theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
  }

  @Cuando("el usuario realiza el flujo con {string} y {string} el seguro")
  public void elUsuarioRealizaElFlujoConYElSeguro(String accountType, String insurance) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            PerformFlow.type(accountType,insurance)
            );
  }
}
