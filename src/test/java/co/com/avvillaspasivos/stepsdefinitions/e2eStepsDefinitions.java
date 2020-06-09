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
import co.com.avvillaspasivos.data.GlobalData;
import co.com.avvillaspasivos.data.JsonFile;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.tasks.Esperas;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.SeleccionCuenta;
import co.com.avvillaspasivos.tasks.SeleccionSeguros;
import co.com.avvillaspasivos.ui.*;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Keys;

public class e2eStepsDefinitions {
    private ActorData actorData;

  @Dado(
      "el usuario con condiciones cliente {string} actualizado {string} canales {string} y cuenta cat {string}")
  public void elUsuarioConCondicionesClienteActualizadoCanalesYCuentaCat(
      String client, String updated, String channels, String cat) {
      actorData =
          DataProvider.getActorData(
              Boolean.valueOf(client),
              Boolean.valueOf(updated),
              Boolean.valueOf(channels),
              Boolean.valueOf(cat),
              false);

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
          .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

      OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Cuando("el usuario diligencia el formulario de identificacion de usuario")
  public void elUsuarioDiligenciaElFormularioDeIdentificacionDeUsuario() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            FormIdentificacion.diligenciar(),
            Click.on(IdentificacionPage.CONTINUAR_BUTTON),
            Esperas.loader());
  }

  @Y("selecciona el producto {string}")
  public void seleccionaElProducto(String tipoCuenta) {
    OnStage.theActorInTheSpotlight().attemptsTo(SeleccionCuenta.tipo(tipoCuenta));
  }

  @Y("{string} el seguro")
  public void elSeguro(String afirmacion) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(SeleccionSeguros.selecciona(afirmacion), Esperas.loader());
    //    if ("acepta".equalsIgnoreCase(afirmacion)) {
    //      OnStage.theActorInTheSpotlight().attemptsTo(SeleccionSeguros.acepta(),
    // Esperas.loader());
    //    } else if ("no acepta".equalsIgnoreCase(afirmacion)) {
    //      OnStage.theActorInTheSpotlight().attemptsTo(SeleccionSeguros.noAcepta(),
    // Esperas.loader());
    //    }
    OnStage.theActorInTheSpotlight().remember(VariablesDeSession.SEGURO.toString(), afirmacion);
  }

  @Y("se autentica mediante otp")
  public void seAutenticaMedianteOtp() {
    String otp = GlobalData.getInstance().getOtp();
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Enter.theValue(otp).into(AutenticacionPage.LIST_OTP_INPUT),
            Click.on(AutenticacionPage.CONTINUAR_BUTTON),
            Esperas.loader(120));
  }

  @Y("{string} la direccion de envio")
  public void laDireccionDeEnvio(String arg0) {
    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(DireccionPage.BOTON_CONTINUAR));
  }

  @Y("{string} que es declarante")
  public void queEsDeclarante(String arg0) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Click.on(DeclarantePage.RADIO_SI),
            Click.on(DeclarantePage.BOTON_CONTINUAR),
            Esperas.loader(Constantes.MAX_WAIT_GET_PDF));

//    ActorData actorData = GlobalData.getInstance().getActorData();
//    String numDoc = actorData.getDocumentNumber();
//    JsonObject joMain = actorData.getJsonObjectDataFlow();
//    JsonObject jsonObjectUser = JsonFile.getUserById(joMain, numDoc);
//
//    JsonFile.setProperty(joMain, jsonObjectUser, "updated", true);

      JsonFile.setProperty("block", true);

  }

  @Y("realiza la firma electronica de documentos")
  public void realizaLaFirmaElectronicaDeDocumentos() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Click.on(FirmaElectronicaPage.CHECK_AUTORIZACION),
            Click.on(FirmaElectronicaPage.BOTON_CONTINUAR),
            Esperas.loader());
  }

  @Entonces("se muestra el resumen de la creacion de la cuenta")
  public void seMuestraElResumenDeLaCreacionDeLaCuenta() {
      JsonFile.setProperty("block", false);

//    ActorData actorData = GlobalData.getInstance().getActorData();
//    String numDoc = actorData.getDocumentNumber();
//    JsonObject joMain = actorData.getJsonObjectDataFlow();
//    JsonObject jsonObjectUser = JsonFile.getUserById(joMain, numDoc);
//
//    JsonFile.setProperty(joMain, jsonObjectUser, "block", false);
//    JsonFile.setProperty(joMain, jsonObjectUser, "cat", true);

    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(ResumenPage.BOTON_ENTENDIDO));

    //    OnStage.theActorInTheSpotlight().attemptsTo(Switch.toWindow("Banco AV Villas"));
    //    OnStage.theActorInTheSpotlight()
    //        .attemptsTo(Click.on(ResumenPage.BOTON_ENTENDIDO), Switch.toWindow("Banco AV
    // Villas"));
  }

  @Y("Selecciono que {string} es PEP")
  public void seleccionoQueEsPEP(String opcion) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Click.on(PepPage.RADIO_NO_PEP), Click.on(PepPage.BOTON_CONTINUAR));
  }

  @Y("{string} el beneficio de excencion de gmf")
  public void elBeneficioDeExcencionDeGmf(String arg0) {
    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(PaqueteProPage.BOTON_CONTINUAR));
  }

  @Y("selecciona actividad economica")
  public void seleccionaActividadEconomica() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Click.on(ActividadEconomicaPage.RADIO_HOGAR),
            Click.on(ActividadEconomicaPage.BOTON_CONTINUAR)
            //            ,
            //            Esperas.loader()
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
}
